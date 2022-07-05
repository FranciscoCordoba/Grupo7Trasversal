package proyectotransversal.g7.vistas;

import proyectotransversal.g7.Modelo.Materia;
import javax.swing.JOptionPane;
import proyectotransversal.g7.Control.Conexion;
import proyectotransversal.g7.Control.MateriaData;
import proyectotransversal.g7.Modelo.Materia;

public class MateriasVista extends javax.swing.JInternalFrame {

    private Conexion con;
    private MateriaData md;

    public MateriasVista() {
	initComponents();
	con = new Conexion();
	md = new MateriaData(con);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtMateria = new javax.swing.JTextField();
        jtID = new javax.swing.JTextField();
        jtAnio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jcActiva = new javax.swing.JCheckBox();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Año");

        jtMateria.setText("Inserte el nombre de la materia");
        jtMateria.setToolTipText("");
        jtMateria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtMateriaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtMateriaFocusLost(evt);
            }
        });
        jtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMateriaActionPerformed(evt);
            }
        });

        jtID.setText("Inserte el ID");
        jtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtIDFocusLost(evt);
            }
        });

        jtAnio.setText("Inserte el año");
        jtAnio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtAnioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtAnioFocusLost(evt);
            }
        });

        jLabel4.setText("Formulario de materias ");

        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        jcActiva.setSelected(true);
        jcActiva.setText("Activa");
        jcActiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcActivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcActiva)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbtnGuardar)
                        .addGap(52, 52, 52)
                        .addComponent(jbtnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jbtnSalir)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcActiva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGuardar)
                    .addComponent(jbtnNuevo)
                    .addComponent(jbtnSalir))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMateriaActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_jtMateriaActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
	// TODO add your handling code here:

	if (jtMateria.getText().equals("Inserte el nombre de la materia") || jtMateria.getText().equals("")) {
	    JOptionPane.showMessageDialog(this, "Error. Por favor ingrese el nombre de la materia");
	}

	try {

	    String nombreMateria = jtMateria.getText();
	    int anio = Integer.parseInt(jtAnio.getText());
	    boolean activa = jcActiva.isEnabled();
	    Materia materia = new Materia(nombreMateria, anio, activa);

		try {

		    md.agregarMateria(materia);
		    JOptionPane.showMessageDialog(this, "Materia agregada con éxito");

		} catch (Exception e) {
		    if (e instanceof java.sql.SQLIntegrityConstraintViolationException) {
			System.out.println(e);
			JOptionPane.showMessageDialog(this, "Error. Ya existe una materia con ese nombre");
		    } else if (e instanceof java.sql.SQLDataException) {
			JOptionPane.showMessageDialog(this, "Error. El nombre de la materia es demasiado largo");
		    } else {
			System.out.println(e);
		    }
		}

	} catch (java.lang.NumberFormatException ex) {
	    JOptionPane.showMessageDialog(this, "Error. El dato ingresado en 'año' NO es un número");
	}

    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
	dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtIDFocusGained
	// TODO add your handling code here:
	if (jtID.getText().equals("Inserte el ID")) {
	    jtID.setText("");
	}
    }//GEN-LAST:event_jtIDFocusGained

    private void jtIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtIDFocusLost
	// TODO add your handling code here:
	if (jtID.getText().equals("")) {
	    jtID.setText("Inserte el ID");
	}
    }//GEN-LAST:event_jtIDFocusLost

    private void jtMateriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtMateriaFocusGained
	// TODO add your handling code here:
	if (jtMateria.getText().equals("Inserte el nombre de la materia")) {
	    jtMateria.setText("");
	}
    }//GEN-LAST:event_jtMateriaFocusGained

    private void jtMateriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtMateriaFocusLost
	// TODO add your handling code here:
	if (jtMateria.getText().equals("")) {
	    jtMateria.setText("Inserte el nombre de la materia");
	}
    }//GEN-LAST:event_jtMateriaFocusLost

    private void jtAnioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtAnioFocusGained
	// TODO add your handling code here:
	if (jtAnio.getText().equals("Inserte el año")) {
	    jtAnio.setText("");
	}
    }//GEN-LAST:event_jtAnioFocusGained

    private void jtAnioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtAnioFocusLost
	// TODO add your handling code here:
	if (jtAnio.getText().equals("")) {
	    jtAnio.setText("Inserte el año");
	}
    }//GEN-LAST:event_jtAnioFocusLost

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
	// TODO add your handling code here:
	jtMateria.setText("");
	jtAnio.setText("");
	jcActiva.setEnabled(true);
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jcActivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcActivaActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_jcActivaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JCheckBox jcActiva;
    private javax.swing.JTextField jtAnio;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtMateria;
    // End of variables declaration//GEN-END:variables
}
