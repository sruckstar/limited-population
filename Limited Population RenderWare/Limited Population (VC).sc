SCRIPT_START //GTA Vice City
{
LVAR_INT scplayer kill_count kill_count_test
LVAR_FLOAT percentage kill_count_float default_population pop_multiplier

percentage = 0.0001
default_population = 1.0
kill_count = 0

main_loop:
WAIT 0
READ_MEMORY 0x978794 4 true kill_count
CSET_LVAR_FLOAT_TO_LVAR_INT kill_count_float kill_count
kill_count_float *= percentage
pop_multiplier = default_population - kill_count_float
SET_PED_DENSITY_MULTIPLIER pop_multiplier
SET_CAR_DENSITY_MULTIPLIER pop_multiplier
GOTO main_loop
}
SCRIPT_END