<template>
    <div class="relative">
        <div class="absolute inset-x-0 top-0 px-2 -mt-4">
            <label class="block w-full px-4 py-1 text-sm bg-milk">
                {{ props.label }}
            </label>
        </div>
        <input
            :type="props.inputType"
            id="date"
            class="
                block
                w-full
                p-2
                border-2
                rounded-md
                bg-milk
                border-saphire
                lg:w-1/3 lg:m-auto lg:my-6
            "
        />
    </div>
</template>

<script setup>
    import { defineProps } from 'vue'
    const props = defineProps({
        label: String,
        inputType: String,
    })

    console.log(props.inputType)
</script>
