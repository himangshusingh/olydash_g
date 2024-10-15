import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { CountryComponent } from './country/country.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent,
    },
    {
        path: 'sidebar',
        component: SidebarComponent,
    },
    {
        path: 'country',
        component: CountryComponent,
    }
];