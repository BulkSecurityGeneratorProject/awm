import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { UFValue } from './ufValue.model';

@Injectable({ providedIn: 'root' })
export class UFService {
    constructor(private http: HttpClient) {}

    fetch(): Observable<HttpResponse<UFValue>> {
        return this.http.get<UFValue>(SERVER_API_URL + 'api/ufCurrentValue', { observe: 'response' });
    }

    identity(): Promise<any> {
        return this.fetch()
            .toPromise()
            .then(response => {
                const ufValue = response.body;
                return ufValue;
            })
            .catch(err => {
                return null;
            });
    }
}
