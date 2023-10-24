SCRIPT_START //GTA 3
{
LVAR_INT scplayer kill_count kill_count_test
LVAR_FLOAT percentage kill_count_float default_population pop_multiplier

percentage = 0.0001
default_population = 1.0
kill_count = 0

main_loop:
WAIT 0
READ_MEMORY 0x978794 4 true kill_count

IF kill_count > 100
AND 200 > kill_count
    SET_PED_DENSITY_MULTIPLIER 0.9
    SET_CAR_DENSITY_MULTIPLIER 0.9
ELSE
    IF kill_count > 200
    AND 300 > kill_count
        SET_PED_DENSITY_MULTIPLIER 0.8
        SET_CAR_DENSITY_MULTIPLIER 0.8
    ELSE
        IF kill_count > 300
        AND 400 > kill_count
            SET_PED_DENSITY_MULTIPLIER 0.7
            SET_CAR_DENSITY_MULTIPLIER 0.7
        ELSE
            IF kill_count > 300
            AND 400 > kill_count
                SET_PED_DENSITY_MULTIPLIER 0.6
                SET_CAR_DENSITY_MULTIPLIER 0.6
            ELSE
                IF kill_count > 400
                AND 500 > kill_count
                    SET_PED_DENSITY_MULTIPLIER 0.5
                    SET_CAR_DENSITY_MULTIPLIER 0.5
                ELSE
                    IF kill_count > 500
                    AND 600 > kill_count
                        SET_PED_DENSITY_MULTIPLIER 0.6
                        SET_CAR_DENSITY_MULTIPLIER 0.6
                    ELSE
                        IF kill_count > 600
                        AND 700 > kill_count
                            SET_PED_DENSITY_MULTIPLIER 0.5
                            SET_CAR_DENSITY_MULTIPLIER 0.5
                        ELSE
                            IF kill_count > 700
                            AND 800 > kill_count
                                SET_PED_DENSITY_MULTIPLIER 0.4
                                SET_CAR_DENSITY_MULTIPLIER 0.4
                            ELSE
                                IF kill_count > 800
                                AND 900 > kill_count
                                    SET_PED_DENSITY_MULTIPLIER 0.3
                                    SET_CAR_DENSITY_MULTIPLIER 0.3
                                ELSE
                                    IF kill_count > 900
                                    AND 1000 > kill_count
                                        SET_PED_DENSITY_MULTIPLIER 0.2
                                        SET_CAR_DENSITY_MULTIPLIER 0.2
                                    ELSE
                                        IF kill_count > 1000
                                        AND 2000 > kill_count
                                            SET_PED_DENSITY_MULTIPLIER 0.1
                                            SET_CAR_DENSITY_MULTIPLIER 0.1
                                        ELSE
                                            IF kill_count > 2000
                                                SET_PED_DENSITY_MULTIPLIER 0.0
                                                SET_CAR_DENSITY_MULTIPLIER 0.0
                                            ENDIF
                                        ENDIF
                                    ENDIF
                                ENDIF
                            ENDIF
                        ENDIF
                    ENDIF
                ENDIF
            ENDIF
        ENDIF
    ENDIF
ENDIF
GOTO main_loop
}
SCRIPT_END