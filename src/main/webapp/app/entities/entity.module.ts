import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AwmAuthorModule } from './author/author.module';
import { AwmCountryModule } from './country/country.module';
import { AwmWorkModule } from './work/work.module';
import { AwmAuthorWorkModule } from './author-work/author-work.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        AwmAuthorModule,
        AwmCountryModule,
        AwmWorkModule,
        AwmAuthorWorkModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwmEntityModule {}
