
package com.dak.views;

import javax.swing.JPanel;

public abstract class AppPage extends JPanel {
    public abstract AppPage cloneState();

    protected AppPage() {
        this.setOpaque(false);
    }
}
