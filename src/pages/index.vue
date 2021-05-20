<template>
    <div class="text-red-500">
        seotnsohe
    </div>
</template>

<script setup>
    import { reactive } from 'vue'
    import { useHead } from '@vueuse/head'

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

    const state = reactive({
    })
</script>
