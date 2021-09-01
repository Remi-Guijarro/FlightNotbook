<template>
    <div class="flex flex-col bg-gray-50 h-5/6">
        <div class="flex-1 bg-milk flex items-center justify-center">
            <div class="w-full h-auto p-5 pt-10 space-y-10">
                <h1 class="text-5xl text-center font-title">Inscription</h1>
                <InputGroup label="Name" input-type="text" />
                <InputGroup label="Last-Name" input-type="text" />
                <InputGroup label="Email" input-type="email" />
                <InputGroup label="Email-Confirmation" input-type="email" />
                <InputGroup label="Birthdate" input-type="date" />
                <InputGroup label="Password" input-type="password" />
                <InputGroup
                    label="Password-Confirmation"
                    input-type="password"
                />
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
                    Go !
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
