const colors = require('tailwindcss/colors')
const defaultTheme = require('tailwindcss/defaultTheme')

module.exports = {
  mode: 'jit',
  purge: {
    mode: 'all',
    content: ['./index.html', './src/**/*.{html,vue,js,ts,jsx,tsx,svelte,md}'],
  },
  darkMode: 'class',
  theme: {
    colors: {
      transparent: 'transparent',
      current: 'currentColor',
      white: colors.white,
      milk: { DEFAULT: '#F9F9F9' },
      black: colors.black,
      gray: colors.gray, // blueGray, coolGray, gray, trueGray, warmGray
      red: colors.red,
      orange: colors.orange,
      amber: colors.amber,
      yellow: colors.yellow,
      lime: colors.lime,
      green: colors.green,
      emerald: colors.emerald,
      teal: colors.teal,
      cyan: colors.cyan,
      sky: colors.lightBlue,
      blue: colors.blue,
      saphire: { DEFAULT: '#28536B' },
      indigo: colors.indigo,
      violet: colors.violet,
      purple: colors.purple,
      fuschia: colors.fuchsia,
      pink: colors.pink,
      rose: colors.rose,
    },
    extend: {
      fontFamily: {
        mono: ['Fira Code var', ...defaultTheme.fontFamily.mono],
        sans: ['Inter var', ...defaultTheme.fontFamily.sans],
        serif: ['Literata var', ...defaultTheme.fontFamily.serif],
        title: ['PoiretOne-Regular'],
      },
    },
  },
  plugins: [],
}
