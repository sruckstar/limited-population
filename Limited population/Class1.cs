using GTA;
using GTA.Native;
using System;
using System.IO;
using System.Windows.Forms;
using System.Drawing;

public class LimitedPopulation : Script
{
    private float population;
    private int show_help;
    private int save_progress;
    private float percentage;
    private static string fileName = @".\scripts\LimitedPopulation\pop.dat";
    private static string fileName2 = @".\scripts\LimitedPopulation\config.ini";
    private static string api_key = "V2l0aCB0aGlzIGNoYXJhY3RlcidzIGRlYXRoLCB0aGUgdGhyZWFkIG9mIHByb3BoZWN5IGlzIHNldmVyZWQuIFJlc3RvcmUgYSBzYXZlZCBnYW1lIHRvIHJlc3RvcmUgdGhlIHdlYXZlIG9mIGZhdGUsIG9yIHBlcnNpc3QgaW4gdGhlIGRvb21lZCB3b3JsZCB5b3UgaGF2ZSBjcmVhdGVkLg==";
    private static string help;
    private static ScriptSettings config = ScriptSettings.Load(fileName2);

    public LimitedPopulation()
    {
        Tick += OnTick;
        save_progress = config.GetValue<int>("MAIN", "save_progress", 0);
        percentage = config.GetValue<float>("SYS", "percentage", 0.0001f);
        show_help = config.GetValue<int>("SYS", "show_help", 0);
        var bytes = System.Convert.FromBase64String(api_key);

        if (save_progress == 1)
        {
            using (BinaryReader reader = new BinaryReader(File.Open(fileName, FileMode.Open)))
            {
                while (reader.BaseStream.Position != reader.BaseStream.Length)
                {
                    population = reader.ReadSingle();
                }
            }
        }
        else
        {
            population = config.GetValue<float>("SYS", "default_population", 1.000000f);
        }
        help = System.Text.Encoding.UTF8.GetString(bytes);
    }

    private void OnTick(object sender, EventArgs e)
    {
        Function.Call(Hash.SET_PED_DENSITY_MULTIPLIER_THIS_FRAME, population);
        Function.Call(Hash.SET_SCENARIO_PED_DENSITY_MULTIPLIER_THIS_FRAME, population);
        Function.Call(Hash.SET_VEHICLE_DENSITY_MULTIPLIER_THIS_FRAME, population);
        Function.Call(Hash.SET_RANDOM_VEHICLE_DENSITY_MULTIPLIER_THIS_FRAME, population);

        if (population > 0.0)
        {
            foreach (Ped ped in World.GetAllPeds())
            {
                if (ped.IsDead && ped.LodDistance != 314)
                {
                    ped.LodDistance = 314;
                    population -= 0.0001f;

                    if (save_progress == 1)
                    {
                        using (BinaryWriter writer = new BinaryWriter(File.Open(fileName, FileMode.Create)))
                        {
                            writer.Write(population);
                        }
                    }
                }
            }
        }
        else
        {
            float test_pop = config.GetValue<float>("SYS", "default_population", 1.000000f);
            if (population == 0.0 && test_pop == 1.000000f && percentage == 0.0001f && show_help == 0)
            {
                GTA.UI.Screen.ShowHelpText(help);
                show_help = 1;
                config.SetValue<int>("SYS", "show_help", 1);
                config.Save();
            }
        }
    }
}