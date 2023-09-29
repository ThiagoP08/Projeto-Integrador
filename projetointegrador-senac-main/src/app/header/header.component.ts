import { Component, Input } from '@angular/core';

@Component({
  selector: 'pro-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  @Input() isWhiteText: boolean = true;
  @Input() isBlackText: boolean = false; // Adicione a propriedade isBlackText
}
