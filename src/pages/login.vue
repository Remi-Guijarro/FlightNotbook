<template>
    <div class="flex flex-col bg-gray-50 h-5/6">
        <div class="flex-1 bg-milk flex items-center justify-center">
            <div class="w-full h-auto p-5 pt-10 space-y-10">
                <h1 class="text-5xl text-center font-title">Connexion</h1>
                <InputGroup label="Email" input-type="email" />
                <InputGroup label="Password" input-type="password" />
                <button
                    class="
                        block
                        w-full
                        p-2
                        mb-10
                        text-white
                        rounded-md
                        bg-saphire
                        lg:w-1/3 lg:m-auto lg:my-6
                    "
                >
                    Connect !
                </button>
            </div>
        </div>
    </div>
</template>

<script setup>
    import { reactive } from 'vue'
    import { useHead } from '@vueuse/head'
    import { NavBar, InputGroup } from '/src/components'

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
