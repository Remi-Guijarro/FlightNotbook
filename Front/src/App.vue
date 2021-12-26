<template>
    <div>
        <router-view></router-view>
        <NavBar class="fixed bottom-0 w-full p-3 lg:fixed" />
    </div>
</template>

<script>
    import { NavBar } from '/src/components'
    export default {
        components: {
            NavBar,
        },
    }
</script>

<style>
    @font-face {
        font-family: 'Inter var';
        font-weight: 100 900;
        font-display: swap;
        font-style: oblique 0deg 10deg;
        src: url('/fonts/Inter.var.woff2') format('woff2');
    }

    @font-face {
        font-family: 'PoiretOne-Regular';
        font-style: normal;
        font-weight: 400;
        font-display: auto;
        src: url('/fonts/PoiretOne-Regular.ttf') format('truetype');
        font-named-instance: 'Regular';
    }
</style>
