/* MovieLanguages´s Form generated by JSetup v0.95 :  at 1 de fev de 2023 09:51:03 */  
import { useEffect, useState } from 'react';
import Head from 'next/head';
import dayjs from 'dayjs';
import Router from 'next/router';
import { TextField, CheckboxWithLabel } from 'formik-mui';
import { Formik, Form, Field } from 'formik';
import { DatePicker } from 'formik-mui-x-date-pickers';

import { Button, LinearProgress, Card, CardContent, CardHeader, Divider, Box, Stack } from '@mui/material';

import { Layout } from '@/components/layout/layout';
import HttpRequest from '@/lib/HttpRequest'
import { useRouter } from 'next/router'

const initValues = {
}

const toMovieLanguages = (values) => {
  return { 
    ...values,
  }
}

const MovieLanguages = () => {
  const service = new HttpRequest("/rs/crud/movieLanguagess");
  const router = useRouter()
  const [formValues, setFormValues] = useState(initValues);
  const { id } = router.query

  useEffect(() => {
    if (!id) return;
    const fetchData = async () => {
      try {
        const response = await service.getById(id);
        const json = await response.data;
        setFormValues(json)
      } catch (err) {
        console.error(err)
      }
    }
    fetchData().catch(console.error);
  }, []);

  const save = async (formValues) => {
    const response = await service.save(toMovieLanguages(formValues));
    const json = await response.data;
    console.log(json)
  }

  const formValidate = (values) => {
    const errors = {};
  /*
  */
    return errors;
  }

  return <>
    <Head>
      <title>
        Cadastro de MovieLanguages
      </title>
    </Head>
    <Card>
      <CardHeader
        title="Novo MovieLanguages"
      />

      <Divider />
      <CardContent>
        <Formik
          enableReinitialize={true}	
          initialValues={formValues}
          validate={formValidate}
          
          onSubmit={(values, { setSubmitting }) => {
          	save(values);
          	setSubmitting(false);
          }}
        >
          {({ submitForm, isSubmitting }) => (
            <Form>
              {isSubmitting && <LinearProgress />}
              <Divider />
              <Box marginTop={2}>
                <Stack direction="row" spacing={2}>
                  <Button
                    variant="contained"
                    color="primary"
                    disabled={isSubmitting}
                    onClick={submitForm}
                  >
                    Salvar
                  </Button>
                  <Button
                    variant="text"
                    color="secondary"
                    disabled={isSubmitting}
                    onClick={() => Router.push('/movieLanguages/list').catch(console.error)}
                  >
                    Ver listagem
                  </Button>
                </Stack>
              </Box>
            </Form>
          )}
        </Formik>
      </CardContent>
      <Divider />
    </Card>
  </>
};

MovieLanguages.getLayout = (movieLanguages) => (
  <Layout>
    {movieLanguages}
  </Layout>
);

export default MovieLanguages;