<template>
    <div class="fixed items-center bg-saphire">
        <div class="grid grid-cols-5 gap-2 place-items-stretch">
            <router-link to="/">
                <div class="grid place-items-center">
                    <HomeIcon class="h-8 w-8 text-white place-items-stretch" />
                </div>
            </router-link>

            <div class="grid place-items-center">
                <UserIcon class="h-8 w-8 text-white" />
            </div>
            <router-link to="/flights/new">
                <div class="grid place-items-center">
                    <PlusCircleIcon class="h-8 w-8 text-white" />
                </div>
            </router-link>
            <div class="grid place-items-center">
                <ArchiveIcon class="h-8 w-8 text-white" />
            </div>
            <div class="grid place-items-center">
                <ChartPieIcon class="h-8 w-8 text-white" />
            </div>
        </div>
    </div>
</template>

<script setup>
    import {
        PlusCircleIcon,
        ArchiveIcon,
        ChartPieIcon,
        HomeIcon,
        UserIcon,
    } from '@heroicons/vue/solid'
</script>
