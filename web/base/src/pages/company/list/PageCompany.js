/* Company´s Search Page generated by JSetup v0.95 :  at 1 de fev de 2023 21:03:52  */
import { useEffect, useState } from 'react';
import Head from 'next/head';
import dayjs from 'dayjs';
import Router from 'next/router';
import { Box,Stack, Container, Typography, Button, Card, CardContent, CardHeader, Divider, TextField } from '@mui/material';
import { DataGrid } from '@mui/x-data-grid'
import { DatePicker } from '@mui/x-date-pickers';

import { Layout } from '@/components/layout/layout';
import { ActionCell } from '@/components/grid/ActionCell';
import HttpRequest from '@/lib/HttpRequest'
const toFilterCompany = (values) => {
  return { 
    ...values,
  }
}

const columns = [
  { field: 'id', headerName: 'ID', width: 90 },
  {
    field: 'name',
    headerName: 'Name',
    width: 150,
    editable: false,
  },	
  {
    field: 'print',
    headerName: 'Ações',
    sortable: false,
    filterable: false,
    editable: false,
    width: 150,
    disableColumnMenu: false,
    renderCell: (cellValues) => <ActionCell
      {...cellValues}
      onEdit={(row) => {
        Router
          .push('/company/edit/' + row.id)
          .catch(console.error);
      }}
      onDelete={(row) => {
        console.log("Removendo o registro ", row);
      }}
    />
  }
];


const Page = () => {
  const service = new HttpRequest("/rs/crud/companys");

  const [pageSize, setPageSize] = useState(5);
  const [pageItems, setPageItems] = useState([]);

  const [page, setPage] = useState(1);
  const [totalItems, setTotalItems] = useState(0);
  const [filter, setFilter] = useState({});
  const [sort, setSort] = useState({ field: 'id', sort: 'desc' });
  const [values, setValues] = useState({
    name: '',	
  });

  const handleChange = (event) => {
    setValues({
      ...values,
      [event.target.name]: event.target.value
    });
  };

  useEffect(() => {
    const fetchData = async () => {
      const response = await service.getPage({ page, pageSize, orderBy: sort.field, direction: sort.sort, ...filter });

      const json = await response.data;
      setPageItems(json.items);
      setTotalItems(json.totalRecords);
    }
    fetchData()
      .catch(console.error);;
  }, [pageSize, page, sort, filter])

  // sortmodel é um array, pegar apenas o primeiro elemento
  const sortChange = (sortModels, detail) => {
    const [sortModel = {}] = sortModels;
    setSort(sortModel);
  }

  const pageChange = (newPageNumber, detail) => {
    console.log(newPageNumber)
    setPage(newPageNumber + 1);
  }

  const searchByFilter = () => {

    setFilter(toFilterCompany(values));
  }
  const pageSizeChange = (newPageSize, detail) => {
    console.log(newPageSize)
    setPageSize(newPageSize)
  }

  return <>
    <Head>
      <title>
        Listagem de Companys
      </title>
    </Head>
    <Card>
      <CardHeader
        title="Filtro de pesquisa"
      />
      <Divider />
      <CardContent>
        <TextField
          fullWidth
          label="Name"
          margin="normal"
          name="name"
          onChange={handleChange}
          type="text"
          value={values.name}
          variant="outlined"
        />
      </CardContent>
      <Divider />
      <Box
        sx={{
          display: 'flex',
          justifyContent: 'flex-start',
          p: 2
        }}
      >
        <Stack direction="row" spacing={2}>
          <Button
            color="primary"
            variant="contained"
            onClick={searchByFilter}
          >
            Pesquisar
          </Button>
          <Button
            color="secondary"
            variant="contained"
            onClick={() => Router.push('/company/new').catch(console.error)}
          >
            Novo
          </Button>
        </Stack>
      </Box>
    </Card>
    <Card>
      <CardHeader
        title="Listagem"
      />
      <Divider />
      <CardContent>
        <Box sx={{ pt: 3 }}>
          <Box sx={{ height: 400, width: '100%' }}>
            <DataGrid
              rows={pageItems}
              columns={columns}
              pageSize={pageSize}
              rowCount={totalItems}
              rowsPerPageOptions={[5, 10, 20]}
              onSortModelChange={sortChange}
              onPageChange={pageChange}
              onPageSizeChange={pageSizeChange}
              sortingMode='server'
              paginationMode='server'
            />
          </Box>
        </Box>
      </CardContent>
    </Card>
  </>
};

Page.getLayout = (page) => (
  <Layout>
    {page}
  </Layout>
);

export default Page;
