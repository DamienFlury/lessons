import Address from './Address';

type Customer = {
    id?: number,
    firstName: string,
    lastName: string,
    address?: Address,
};

export default Customer;
