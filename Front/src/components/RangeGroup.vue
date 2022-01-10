<template>
    <div>
        <span>{{ props.title + ': ' + props.watchedValue || '1' }}</span>
        <input
            class="block w-full h-3 p-2 mt-5 mb-5 overflow-hidden bg-gray-300 rounded-lg appearance-none lg:w-1/3 lg:m-auto lg:my-6"
            type="range"
            name="nb-landing"
            id="nb-landing"
            :min="props.minValue"
            :max="props.maxValue"
            @input="(event) => emit('change', event.target.value)"
            :value="props.watchedValue"
        />
    </div>
</template>

<script setup>
    const props = defineProps({
        title: String,
        inputType: String,
        inputValue: String,
        watchedValue: { type: String, default: '1' },
        minValue: Number,
        maxValue: Number,
    })

    const emit = defineEmits(['change'])
</script>

<style></style>
