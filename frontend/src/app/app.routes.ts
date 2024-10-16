import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { CountryComponent } from './country/country.component';
import { SportComponent } from './sport/sport.component';
import { AthleteComponent } from './athlete/athlete.component';
import { EventComponent } from './event/event.component';

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
    },
    {
        path: 'sport',
        component: SportComponent,
    },
    {
        path: 'athlete',
        component: AthleteComponent,
    },
    {
        path: 'event',
        component: EventComponent,
    }
];