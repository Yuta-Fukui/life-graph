module.exports = {
  devServer: {
    proxy: {
      '/api/': {
        target: 'http://localhost'
      }
    }
  },
  transpileDependencies: [
    'vuetify'
  ]
}
