<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Capgemini Logo"
          class="shrink mr-2"
          contain
          src="https://prod.ucwe.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo-white.svg"
          transition="scale-transition"
          width="200"
        />
      </div>

      <v-spacer></v-spacer>

      <span class="mr-2">Bank Application</span>

    </v-app-bar>

    <v-main>
      <Customer-Table/>
    </v-main>
  </v-app>
</template>

<script>
import CustomerTable from './components/Customer.vue'

export default {
  name: 'App',

  components: {
    CustomerTable,
  },

  data: () => ({
    //
  }),
};
</script>
