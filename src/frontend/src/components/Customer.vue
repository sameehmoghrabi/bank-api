<template>
  <div>
    <v-data-table
      item-key="id"
      :headers="customersHeaders"
      :items="customers"
      :single-expand="true"
      :page.sync="page"
      :items-per-page="itemsPerPage"
      :expanded.sync="expanded"
      show-expand
      class="elevation-1"
      style="cursor: pointer"
      hide-default-footer
      @click:row="rowClicked"
      @page-count="pageCount = $event"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Customers</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
        </v-toolbar>
      </template>
      <template v-slot:expanded-item="{ headers, item }">
        <AccountTable
          @update-customer="updateCustomer"
          :key="item.id"
          :colspan="headers.length"
          :accounts="item.accounts"
          :customer-id="item.id"
        />
      </template>
    </v-data-table>
    <div class="text-center pt-2">
      <v-pagination v-model="page" :length="pageCount"></v-pagination>
    </div>
  </div>
</template>

<script>
import { HttpStatusCode } from "axios";
import CustomerService from "../services/CustomerService";
import AccountTable from "./Account.vue";

export default {
  name: "CustomerTable",

  components: {
    AccountTable,
  },

  data: () => ({
    page: 1,
    pageCount: 0,
    itemsPerPage: 10,
    customers: [],
    expanded: [],
    customersHeaders: [
      {
        text: "ID",
        align: "start",
        sortable: true,
        value: "id",
      },
      {
        text: "Name",
        align: "start",
        sortable: true,
        value: "name",
      },
      {
        text: "Surname",
        align: "start",
        sortable: true,
        value: "surname",
      },
      { text: "", value: "data-table-expand" },
    ],
  }),

  methods: {
    getCustomers() {
      CustomerService.getCustomers().then((response) => {
        this.customers = response.data;
      });
    },

    updateCustomer(customerId) {
      CustomerService.getCustomer(customerId).then((response) => {
        if (response && response.status == HttpStatusCode.Ok) {
          var index = this.customers.findIndex(
            (element) => element.id == customerId
          );
          if (index > -1) {
            this.customers.splice(index, 1, response.data);
          }
        }
      });
    },

    rowClicked(item, event) {
      if (event.isExpanded) {
        this.expanded = [];
      } else {
        this.expanded = [item];
      }
    },
  },

  created() {
    this.getCustomers();
  },
};
</script>>

