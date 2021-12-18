import cdnAuto from 'vite-plugin-cdn-auto'
import compress from 'vite-plugin-compress'
import path from 'path'
import svgLoader from 'vite-svg-loader'
import vue from '@vitejs/plugin-vue'
import pages from 'vite-plugin-pages'

/**
 * @type {import('vite').UserConfig}
 */
export default {
  resolve: {
    alias: {
      '/src': path.resolve(__dirname, 'src'),
    },
  },
  plugins: [
    vue(),
    pages(),
    cdnAuto(),
    svgLoader(),
    compress({ brotli: false }),
  ],
}
