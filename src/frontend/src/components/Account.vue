<template>
  <td class="account-table">
    <v-data-table
      id="accountsT"
      :headers="accountHeaders"
      :items="accounts"
      :single-expand="true"
      item-key="id"
      show-expand
      class="elevation-1"
      :expanded.sync="expanded"
      @click:row="rowClicked"
      :hide-default-footer="true"
    >
      <template v-slot:top>
        <v-toolbar flat dense>
          <v-toolbar-title>Accounts</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-dialog v-model="dialog" max-width="500px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                color="primary"
                dark
                small
                class=""
                v-bind="attrs"
                v-on="on"
              >
                New Account
              </v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="text-h5">New Account</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="newItem.customerId"
                        type="number"
                        label="Customer ID"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        type="number"
                        v-model="newItem.initialCredit"
                        label="Initial Credit"
                      ></v-text-field>
                    </v-col>
                  </v-row>
                  <v-row v-if="error" style="color:red"> {{ errorMessage }}</v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="close">
                  Cancel
                </v-btn>
                <v-btn color="blue darken-1" text @click="save"> Save </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </template>
      <template v-slot:expanded-item="{headers, item }">
        <TransactionTable :key="item.id"
          :colspan="headers.length"
          :transactions="item.transactions"/>
      </template>
    </v-data-table>
  </td>
</template>
  
<script>
import AccountService from "../services/AccountService";
import TransactionTable from "./Transaction.vue";
import { HttpStatusCode } from "axios";

export default {
  name: "AccountTable",

  components: {
    TransactionTable,
  },

  data: () => ({
    error: false,
    errorMessage: "Account creation failed!",
    dialog: false,
    expanded: [],
    accountHeaders: [
      {
        text: "ID",
        align: "start",
        sortable: true,
        value: "id",
      },
      {
        text: "Balance",
        align: "start",
        sortable: true,
        value: "balance",
      },
      { text: "", value: "data-table-expand" },
    ],
    newItem: {
      customerId: "",
      initialCredit: 0,
    },
    defaultItem: {
      customerId: 0,
      initialCredit: 0,
    },
  }),

  watch: {
    dialog(val) {
      val || this.close();
    },
  },

  props: {
    accounts: [],
    customerId: {
      type: Number,
      default: 0,
    },
  },

  created() {
    this.defaultItem.customerId = this.customerId;
    this.newItem.customerId = this.customerId;
  },

  methods: {
    rowClicked(item, event) {
      if (event.isExpanded) {
        this.expanded = [];
      } else {
        this.expanded = [item];
      }
    },
    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.newItem = Object.assign({}, this.defaultItem);
        this.error = false;
      });
    },
    save() {
      AccountService.createAccount(this.newItem).then((response) => {
        if (response && response.status == HttpStatusCode.Created) {
          this.$emit("update-customer", this.customerId);
          this.close();
        } else {
            this.error = true;
        }
      });
    },
  },
};
</script>

<style>
#accountsT {
  margin: 30px;
  cursor: pointer;
}
.account-table {
  padding: 0px;
  background-color: #eeeeee;
}
</style>



  
  