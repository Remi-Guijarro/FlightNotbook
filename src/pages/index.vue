<template>
    <div class="flex flex-col bg-gray-50 h-5/6">
        <div class="flex-1 bg-milk flex items-center justify-center"></div>
    </div>
    <NavBar class="p-4 w-screen fixed bottom-0" />
</template>

<script setup>
    import { reactive } from 'vue'
    import { useHead } from '@vueuse/head'
    import { NavBar } from '/src/components'

    import packageJSON from '/src/../package.json'

    useHead({
        title: packageJSON.name,
        meta: [
            {
                name: 'description',
                content: packageJSON.description,
            },
        ],
    })

    const state = reactive({})
</script>
