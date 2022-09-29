package growthcraft.rice.shared;

import org.codehaus.plexus.util.StringUtils;

public class Reference {
    public static final String NAME_SHORT = "rice";

    public static final String MODID = growthcraft.core.shared.Reference.MODID + "_" + NAME_SHORT;
    public static final String NAME = String.format("%s %s",
            growthcraft.core.shared.Reference.NAME,
            StringUtils.capitalise(NAME_SHORT));

    public static final String VERSION = growthcraft.core.shared.Reference.VERSION;

    public static class UnlocalizedName {

        private UnlocalizedName() {
            /* Disable Automatic Creation of Public Constructor */
        }
    }

    public static class FluidColor {

        private FluidColor() {
            /* Disable Automatic Creation of Public Constructor */
        }
    }

    private Reference() {
        /* Disable Automatic Creation of Public Constructor */
    }
}
