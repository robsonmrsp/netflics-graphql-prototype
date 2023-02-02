import IntegrationInstructionsRoundedIcon from '@mui/icons-material/IntegrationInstructionsRounded';
import { Box, Divider, Drawer, useMediaQuery } from '@mui/material';
import NextLink from 'next/link';
import { useRouter } from 'next/router';
import PropTypes from 'prop-types';
import { useEffect } from 'react';
import { Logo } from '../logo';
import { NavItem } from './nav-item';

const items = [
  {
    href: '/movieCast/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de movieCast'
  },
  {
    href: '/movieCast/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo movieCast'
  },
  
  {
    href: '/keyword/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de keyword'
  },
  {
    href: '/keyword/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo keyword'
  },
  
  {
    href: '/company/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de company'
  },
  {
    href: '/company/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo company'
  },
  
  {
    href: '/movie/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de movie'
  },
  {
    href: '/movie/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo movie'
  },
  
  {
    href: '/language/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de language'
  },
  {
    href: '/language/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo language'
  },
  
  {
    href: '/movieLanguage/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de movie language'
  },
  {
    href: '/movieLanguage/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo movie language'
  },
  
  {
    href: '/languageRole/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de languageRole'
  },
  {
    href: '/languageRole/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo languageRole'
  },
  
  {
    href: '/country/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de country'
  },
  {
    href: '/country/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo country'
  },
  
  {
    href: '/person/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de person'
  },
  {
    href: '/person/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo person'
  },
  
  {
    href: '/movieCrew/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de movieCrew'
  },
  {
    href: '/movieCrew/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo movieCrew'
  },
  
  {
    href: '/gender/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de gender'
  },
  {
    href: '/gender/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo gender'
  },
  
  {
    href: '/genre/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de genre'
  },
  {
    href: '/genre/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo genre'
  },
  
  {
    href: '/department/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de department'
  },
  {
    href: '/department/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo department'
  },
  
  {
    href: '/user/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de usuário'
  },
  {
    href: '/user/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo usuário'
  },
  
  {
    href: '/role/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de papel'
  },
  {
    href: '/role/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo papel'
  },
  
  {
    href: '/permission/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de permissão'
  },
  {
    href: '/permission/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo permissão'
  },
  
  {
    href: '/group/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de grupo de Permissões'
  },
  {
    href: '/group/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo grupo de Permissões'
  },
  
  {
    href: '/item/list',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Lista de item'
  },
  {
    href: '/item/new',
    icon: (<IntegrationInstructionsRoundedIcon fontSize="small" />),
    title: 'Novo item'
  },
  
];

export const Sidebar = (props) => {
  const { open, onClose } = props;
  const router = useRouter();
  const lgUp = useMediaQuery((theme) => theme.breakpoints.up('lg'), {
    defaultMatches: true,
    noSsr: false
  });

  useEffect(
    () => {
      if (!router.isReady) {
        return;
      }

      if (open) {
        onClose?.();
      }
    },
    // eslint-disable-next-line react-hooks/exhaustive-deps
    [router.asPath]
  );

  const content = (
    <>
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'column',
          height: '100%'
        }}
      >
        <div>
          <Box sx={{ p: 3 }}>
            <NextLink
              href="/"
              passHref
            >
              <a>
                <Logo
                  sx={{
                    height: 42,
                    width: 42
                  }}
                />
              </a>
            </NextLink>
          </Box>
        </div>
        <Divider
          sx={{
            borderColor: '#2D3748',
            my: 3
          }}
        />
        <Box sx={{ flexGrow: 1 }}>
          {items.map((item) => (
            <NavItem
              key={item.title}
              icon={item.icon}
              href={item.href}
              title={item.title}
            />
          ))}
        </Box>
        <Divider sx={{ borderColor: '#2D3748' }} />
        <Box
          sx={{
            px: 2,
            py: 3
          }}
        >
        </Box>
      </Box>
    </>
  );

  if (lgUp) {
    return (
      <Drawer
        anchor="left"
        open
        PaperProps={{
          sx: {
            backgroundColor: 'neutral.900',
            color: '#FFFFFF',
            width: 280
          }
        }}
        variant="permanent"
      >
        {content}
      </Drawer>
    );
  }

  return (
    <Drawer
      anchor="left"
      onClose={onClose}
      open={open}
      PaperProps={{
        sx: {
          backgroundColor: 'neutral.900',
          color: '#FFFFFF',
          width: 280
        }
      }}
      sx={{ zIndex: (theme) => theme.zIndex.appBar + 100 }}
      variant="temporary"
    >
      {content}
    </Drawer>
  );
};

Sidebar.propTypes = {
  onClose: PropTypes.func,
  open: PropTypes.bool
};
