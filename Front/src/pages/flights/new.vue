<template>
    <div class="flex flex-col items-center h-auto p-5 lg:h-auto bg-milk">
        <h1 class="text-5xl text-center font-title">Nouveau Vol</h1>
        <div class="w-full pt-10 space-y-10">
            <InputGroup
                label="Date"
                input-type="date"
                @change="(value) => (state.flightRecord.date = value)"
                :watchedValue="state.flightRecord.date"
            />
            <InputGroup
                label="Heure"
                input-type="time"
                @change="(value) => (state.flightRecord.time = value)"
                :watchedValue="state.flightRecord.time"
            />
            <InputGroup
                label="Immatriculation"
                input-type="text"
                @change="(value) => (state.flightRecord.immat = value)"
                :watchedValue="state.flightRecord.immat"
            />
        </div>
        <div class="w-full space-y-10 pt-10">
            <select
                class="block w-full p-2 border-2 rounded-md border-saphire lg:w-1/3 lg:m-auto lg:my-6"
                name="flight-nature"
                id="flight-n"
                @change="(value) => (state.flightRecord.type = value)"
            >
                <option value="Loisir">Loisir</option>
                <option value="Instruction">Instruction</option>
            </select>
        </div>
        <div class="w-full space-y-10 pt-10">
            <InputGroup
                label="Aerodrome depart"
                input-type="text"
                @change="(value) => (state.flightRecord.aeroDep = value)"
                :watchedValue="state.flightRecord.aerodep"
            />
            <InputGroup
                label="Aerodrome arrivee"
                input-type="text"
                @change="(value) => (state.flightRecord.aeroArr = value)"
                :watchedValue="state.flightRecord.aeroarr"
            />
        </div>

        <div class="w-full space-y-10 pt-10">
            <InputGroup
                label="Horametre depart"
                input-type="time"
                @change="(value) => (state.flightRecord.horaDep = value)"
                :watchedValue="state.flightRecord.horadep"
            />
            <InputGroup
                label="Horametre arrivee"
                input-type="time"
                @change="(value) => (state.flightRecord.horaArr = value)"
                :watchedValue="state.flightRecord.horaarr"
            />
        </div>
        <div class="w-full space-y-10 pt-10">
            <!-- <input
                class="block w-full h-3 p-2 mt-5 mb-5 overflow-hidden bg-gray-300 rounded-lg appearance-none lg:w-1/3 lg:m-auto lg:my-6"
                type="range"
                name="nb-landing"
                id="nb-landing"
                v-model="state.flightRecord.nbLanding"
                min="0"
            /> -->
            <RangeGroup
                @change="(value) => (state.flightRecord.nbLanding = value)"
                :watchedValue="state.flightRecord.nbLanding"
                :maxValue="10"
                :minValue="1"
                title="Nombre d'aterrissage"
            />
        </div>
        <div class="w-full">
            <textarea
                class="block w-full p-2 mt-5 mb-5 border-2 rounded-md border-saphire lg:w-1/3 lg:m-auto lg:my-6"
                name="commentary"
                id=""
                cols="30"
                rows="10"
                v-model="state.flightRecord.comment"
            ></textarea>
        </div>
        <div class="w-full mb-10">
            <button
                class="block w-full p-2 mb-10 text-white rounded-md bg-saphire lg:w-1/3 lg:m-auto lg:my-6"
                @click.prevent="pushFlight"
            >
                Validate
            </button>
        </div>
    </div>
</template>

<script>
    import { InputGroup, RangeGroup } from '/src/components'
    import '../../services/repository/FlightRecordRepository'
    import FlightRecordRepository from '../../services/repository/FlightRecordRepository'
    import { reactive } from 'vue'

    export default {
        components: {
            InputGroup,
            RangeGroup,
        },

        setup() {
            const state = reactive({
                flightRecord: {
                    date: '',
                    time: '',
                    immat: '',
                    type: '',
                    aeroDep: '',
                    aeroArr: '',
                    horaDep: '',
                    horaArr: '',
                    nbLanding: '1',
                    comment: '',
                },
            })

            let pushFlight = () => {
                console.log(state.flightRecord)
                let repository = new FlightRecordRepository()
                repository.save(state.flightRecord)
            }

            return {
                state,
                pushFlight,
            }
        },
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
