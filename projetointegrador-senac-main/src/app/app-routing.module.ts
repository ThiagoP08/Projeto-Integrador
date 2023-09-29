import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EventosComponent } from './eventos/eventos.component';
import { EventoInfoComponent } from './evento-info/evento-info.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { CarteiraComponent } from './carteira/carteira.component';
import { AnunciarEventoComponent } from './anunciar-evento/anunciar-evento.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'eventos/:id', component: EventosComponent},
  {path: 'evento-info/:id', component: EventoInfoComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'carteira', component: CarteiraComponent},
  {path: 'anunciar-evento', component: AnunciarEventoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
