export interface Credenciais {
    usuario: string;
    senha: string;
}

export interface CredenciaisVO {
    username: string;
    password: string;
}

export interface CredenciaisReturned {
    username: string;
    authenticated: boolean;
    created: string;
    expiration: string;
    accessToken: string;
    refreshToken: string;

}
