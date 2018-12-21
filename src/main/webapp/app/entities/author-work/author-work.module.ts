import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwmSharedModule } from 'app/shared';
import {
    AuthorWorkComponent,
    AuthorWorkDetailComponent,
    AuthorWorkUpdateComponent,
    AuthorWorkDeletePopupComponent,
    AuthorWorkDeleteDialogComponent,
    authorWorkRoute,
    authorWorkPopupRoute
} from './';

const ENTITY_STATES = [...authorWorkRoute, ...authorWorkPopupRoute];

@NgModule({
    imports: [AwmSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AuthorWorkComponent,
        AuthorWorkDetailComponent,
        AuthorWorkUpdateComponent,
        AuthorWorkDeleteDialogComponent,
        AuthorWorkDeletePopupComponent
    ],
    entryComponents: [AuthorWorkComponent, AuthorWorkUpdateComponent, AuthorWorkDeleteDialogComponent, AuthorWorkDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwmAuthorWorkModule {}
