<template>
    <div class="flex flex-col items-center h-auto p-5 lg:h-auto bg-milk">
        <h1 class="text-5xl text-center font-title">Nouveau Vol</h1>
        <div class="w-full pt-10 space-y-10">
            <InputGroup label="Date" input-type="date" />
            <InputGroup label="Heure" input-type="time" />
            <InputGroup label="Immatriculation" input-type="text" />
        </div>
        <div class="w-full space-y-10 pt-10">
            <select
                class="
                    block
                    w-full
                    p-2
                    border-2
                    rounded-md
                    border-saphire
                    lg:w-1/3 lg:m-auto lg:my-6
                "
                name="flight-nature"
                id="flight-n"
            >
                <option value="">Loisir</option>
                <option value="">Instruction</option>
            </select>
        </div>
        <div class="w-full space-y-10 pt-10">
            <InputGroup label="Aerodrome depart" input-type="text" />
            <InputGroup label="Aerodrome arrivee" input-type="text" />
        </div>

        <div class="w-full space-y-10 pt-10">
            <InputGroup label="Horametre depart" input-type="time" />
            <InputGroup label="Horametre arrivee" input-type="time" />
        </div>
        <div class="w-full space-y-10 pt-10">
            <input
                class="
                    block
                    w-full
                    h-3
                    p-2
                    mt-5
                    mb-5
                    overflow-hidden
                    bg-gray-300
                    rounded-lg
                    appearance-none
                    lg:w-1/3 lg:m-auto lg:my-6
                "
                type="range"
                name="nb-landing"
                id="nb-landing"
            />
        </div>
        <div class="w-full">
            <textarea
                class="
                    block
                    w-full
                    p-2
                    mt-5
                    mb-5
                    border-2
                    rounded-md
                    border-saphire
                    lg:w-1/3 lg:m-auto lg:my-6
                "
                name="commentary"
                id=""
                cols="30"
                rows="10"
            ></textarea>
        </div>
        <div class="w-full mb-10">
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
                Validate
            </button>
        </div>
    </div>
</template>

<script setup>
    import { InputGroup } from '/src/components'
    import '../../services/DatabaseService'

    const directive = {
        beforeMount: (el) => {
            this.db = DatabaseService()
        },
    }

    function pushFlight() {
        this.db
            .driver()
            .from('flight')
            .insert([{}])
            .then((data) => {
                console.log(data)
            })
    }
</script>

<style>
    @media screen and (-webkit-min-device-pixel-ratio: 0) {
        input[type='range']::-webkit-slider-thumb {
            width: 15px;
            -webkit-appearance: none;
            appearance: none;
            height: 15px;
            cursor: ew-resize;
            background: #fff;
            box-shadow: -405px 0 0 400px #28536b;
            border-radius: 50%;
        }
    }
</style>
