const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: [
    'vuetify'
  ],
  configureWebpack: {
    devtool: 'source-map'
  },
  devServer: {
    port: 3000,
    proxy: {
        '/v1': {
            target: 'http://localhost:8080',
            ws: true,
            changeOrigin: true
        }
    }
}
})
