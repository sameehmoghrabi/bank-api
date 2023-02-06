import axios from 'axios'

const ACCOUNT_API_BASE_URL = "/v1/accounts";

class AccountService {
    async createAccount(data) {
        return await axios.post(ACCOUNT_API_BASE_URL + '/add', data).then((response) => {
            return response;
        })
            .catch(function (error) {
                console.log(error);
            });

    }
}

export default new AccountService()