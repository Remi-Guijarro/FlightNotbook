<template>
    <div class="flex flex-col bg-gray-50 h-5/6">
        <div
            id="flight-records"
            class="flex-1 bg-milk flex items-center justify-center"
        >
            <div v-for="flight in state.flights" :key="flight.uiud">
                <InputGroup
                    label="Date du vol"
                    input-type="date"
                    :inputValue="flight.date"
                    readonly="readonly"
                />
                <InputGroup
                    label="Immatriculation"
                    input-type="text"
                    :inputValue="flight.immat"
                    readonly="readonly"
                />

                <InputGroup
                    label="Type de vol"
                    input-type="text"
                    :inputValue="flight.typeVol"
                    readonly="readonly"
                />

                <InputGroup
                    label="Départ de"
                    input-type="text"
                    :inputValue="flight.aeroDep"
                    readonly="readonly"
                />

                <InputGroup
                    label="Arrivé à"
                    input-type="text"
                    :inputValue="flight.aeroArr"
                    readonly="readonly"
                />

                <InputGroup
                    label="Horamètre départ"
                    input-type="time"
                    :inputValue="flight.horaDep"
                    readonly="readonly"
                />

                <InputGroup
                    label="Horamètre arrivé"
                    input-type="time"
                    :inputValue="flight.horaArr"
                    readonly="readonly"
                />
                <p>Nombre d'atterrissage {{ flight.nbLanding }}</p>
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
                        :value="flight.comment"
                    ></textarea>
                </div>
            </div>
        </div>
    </div>
    <NavBar class="p-4 w-screen fixed bottom-0" />
</template>

<script>
    import { onMounted, reactive } from 'vue'
    import { useHead } from '@vueuse/head'
    import { NavBar, InputGroup } from '/src/components'
    import axios from 'axios'
    import packageJSON from '/src/../package.json'

    export default {
        components: {
            NavBar,
            InputGroup,
        },

        setup() {
            useHead({
                title: packageJSON.name,
                meta: [
                    {
                        name: 'description',
                        content: packageJSON.description,
                    },
                ],
            })
            onMounted(() => {
                getAllFlightRecord()
            })
            function getAllFlightRecord() {
                // http://localhost:9090/api/flight-record
                axios
                    .get('http://localhost:9090/api/flight-record')
                    .then((response, error) => {
                        state.flights = response.data
                        console.log(state.flights)
                    })
                    .catch((err) => {
                        console.log(err)
                    })
            }

            const state = reactive({
                flights: [],
            })

            return { state }
        },
    }
</script>

<style scoped>
    #flight-records {
        display: flex;
        flex-direction: column;
    }
</style>
