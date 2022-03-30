import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-filtering-demo',
  templateUrl: './filtering-demo.component.html',
  styleUrls: ['./filtering-demo.component.css']
})
export class FilteringDemoComponent implements OnInit {

  reimbursements = [{id: 1, amount: 20.0, status: 'pending' }, { id: 2, amount: 25.2, status: 'approved'}, { id: 3, amount: 255.1, status: 'denied'}]
  statusFilter: string = 'pending';

  constructor() { }

  ngOnInit(): void {
  }

}
