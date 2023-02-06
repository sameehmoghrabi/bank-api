import axios from 'axios'

const CUSTOMER_API_BASE_URL = "/v1/customers";


class CustomerService {
    async getCustomers() {
        return await axios.get(CUSTOMER_API_BASE_URL);
    }
    async getCustomer(customerId) {
        return await axios.get(CUSTOMER_API_BASE_URL + '/' + customerId)
    }
}

export default new CustomerService()