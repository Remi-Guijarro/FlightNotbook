import { createApp } from 'vue'
import { createHead } from '@vueuse/head'
import generatedRoutes from 'virtual:generated-pages'
import router from './router'

import 'tailwindcss/tailwind.css'

import App from './App.vue'

createApp(App).use(createHead()).use(router).mount('#app')
