package unadm.adcr.main;

import javax.swing.SwingUtilities;

/**
 *
 * @author Adán Cortés R.
 * @matricula ES251118724
 * @grupo DS-DPO2-2602-B1-001
 *
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            PrincipalFrame principal = new PrincipalFrame();
            principal.setVisible(true);
        });
    }
}
