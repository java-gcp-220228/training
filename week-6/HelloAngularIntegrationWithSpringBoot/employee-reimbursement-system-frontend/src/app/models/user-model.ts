import { Role } from "./role-model";

export interface User{
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    role: Role;
}
