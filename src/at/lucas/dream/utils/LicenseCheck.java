package at.lucas.dream.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LicenseCheck {
    private static File configtxt = new File("plugins/DreamAllInOne/License.yml");
    private static YamlConfiguration confittxtyml = YamlConfiguration.loadConfiguration(configtxt);

    public static boolean checkLicense() {
        if (confittxtyml.getString("License").equalsIgnoreCase("TEM8S2-2ET83-CGKP1-DPSI2-EPZO1")
           || confittxtyml.getString("License").equalsIgnoreCase("TEM8S22ET83CGKP1DPSI2EPZO1")){
            return true;

        }else
        return false;
    }

    public static void createLicense() {
        if (!(configtxt.exists())) {
            try {
                configtxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            confittxtyml.set("License", "Replace this with License-key");
            save();
        }
    }


    public static void save() {
        try {
            confittxtyml.save(configtxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
