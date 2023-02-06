<template>
  <td class="account-table">
    <v-data-table
      id="transactionsT"
      :headers="transactionsHeaders"
      :items="transactions"
      item-key="id"
      class="elevation-1"
      style="cursor: default"
      hide-default-footer
    >
      <template v-slot:top>
        <v-toolbar flat dense>
          <v-toolbar-title>Transactions</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
        </v-toolbar>
      </template>
    </v-data-table>
  </td>
</template>

<script>
export default {
  name: "TransactionTable",

  data: () => ({
    transactionsHeaders: [
      {
        text: "ID",
        align: "start",
        sortable: true,
        value: "id",
      },
      {
        text: "Amount",
        align: "start",
        sortable: true,
        value: "amount",
      },
    ],
  }),

  props: {
    transactions: []
  },

  methods: {},

  created() {},
};
</script>

<style>
#transactionsT {
  margin: 30px;
  cursor: pointer;
}
</style>

