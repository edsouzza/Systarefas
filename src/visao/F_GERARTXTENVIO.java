package visao;

import Dao.DAOPatrimonio;
import biblioteca.Biblioteca;
import biblioteca.CampoTxtLimitadoPorQdeCaracteres;
import biblioteca.CampoTxtLimitadoPorQdeCaracteresUpperCase;
import biblioteca.GerarTXT;
import biblioteca.MetodosPublicos;
import biblioteca.RetornarQdeLinhasDoTxt;
import biblioteca.SelecionarArquivoTexto;
import static biblioteca.VariaveisPublicas.anoVigente;
import static biblioteca.VariaveisPublicas.codigoUsuario;
import static biblioteca.VariaveisPublicas.lstAuxiliar;
import static biblioteca.VariaveisPublicas.lstListaCampos;
import static biblioteca.VariaveisPublicas.dataDoDia;
import static biblioteca.VariaveisPublicas.destinoTransferidos;
import static biblioteca.VariaveisPublicas.numMemoTransferido;
import static biblioteca.VariaveisPublicas.origemTransferidos;
import static biblioteca.VariaveisPublicas.valorItem;
import static biblioteca.VariaveisPublicas.valorPesquisaTrue;
import controle.ControleGravarLog;
import controle.CtrlPatriItenstransferido;
import controle.CtrlPatriTransferido;
import controle.CtrlPatrimonio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.PatriTensTransferido;
import modelo.PatriTransferido;
import modelo.Patrimonio;
import relatorios.GerarRelatorios;

public class F_GERARTXTENVIO extends javax.swing.JFrame {
    MetodosPublicos                umMetodo                     = new MetodosPublicos();
    Biblioteca                     umaBiblio                    = new Biblioteca();
    GerarTXT                       objGerarTXT                  = new GerarTXT();
    DefaultListModel               model                        = new DefaultListModel();
    Patrimonio                     umModPatrimonio              = new Patrimonio();
    CtrlPatrimonio                 umControlePatrimonio         = new CtrlPatrimonio();
    ControleGravarLog              umGravarLog                  = new ControleGravarLog();
    CtrlPatriItenstransferido      umCtrlPatrItemTranferido     = new CtrlPatriItenstransferido();
    CtrlPatriTransferido           umCtrlPatriTranferido        = new CtrlPatriTransferido();
    PatriTransferido               umModPatriTransferido        = new PatriTransferido();
    PatriTensTransferido           umModPatrItensTransferido    = new PatriTensTransferido();
    PatriTensTransferido           objModPatriTemTransferido    = new PatriTensTransferido();
    CtrlPatriItenstransferido      ctrlPatriTenstransferido     = new CtrlPatriItenstransferido();
    DAOPatrimonio                  umDaoPatri                   = new DAOPatrimonio();
    DateFormat                     sdf                          = new SimpleDateFormat("dd/MM/yyyy");
    Date dataDia                                                = dataDoDia; 
    
    String sTipo, sChapa, sSerie, sEstacao, sCodigo, sStatus, sMotivo, sObs, sOrigem, sDestino, sMemorando, sObservacoes,sObsMemo, sMemoobservacao,sSecaoid, sClienteid, caminhoTXT, linha, sstatusItem  = "";
    int iTipoid, codItem, codMOdelo, codPatr, contador, codSecao, codCliente, cont = 0;
    Boolean metodoPADRAOINIFIM,inserindo,inseriuItem = false;   
    String[] getDados;
    
    public F_GERARTXTENVIO(java.awt.Frame parent, boolean modal) {       
        initComponents();
        Leitura();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); //desabilitando o botao fechar

        //Impede que formulario seja arrastado na tela
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                setEnabled(false);
                setEnabled(true);
            }
        });//fim addComponentListener

        //configuracoes dos edits      
        umMetodo.configurarBotoes(btnGerarTXT);
        umMetodo.configurarBotoes(btnADDAOTXT);
        umMetodo.configurarBotoes(btnLimpar);
        umMetodo.configurarBotoes(btnSair);
        umMetodo.configurarBotoes(btnNovo);
        umMetodo.configurarBotoes(btnRemoverItem);
        
        lstITENS.setForeground(Color.blue);        
        lstITENS.setFont(new Font("TimesRoman", Font.BOLD, 14));
        txtPESQUISA.setDocument(new CampoTxtLimitadoPorQdeCaracteresUpperCase(20));  
        umaBiblio.configurarCamposTextos(txtDESTINO);
        txtOBSERVACAO.setDocument(new CampoTxtLimitadoPorQdeCaracteres(80));  
        txtOBSERVACAO.setFont(new Font("TimesRoman", Font.BOLD, 14));
        txtMENSAGEM.setFont(new Font("TimesRoman", Font.BOLD, 14));
        txtMENSAGEM.setForeground(Color.red);
        txtMEMORANDO.setForeground(Color.red);
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPANELTOTAL = new javax.swing.JPanel();
        jBoxPesquisar1 = new javax.swing.JLayeredPane();
        txtMEMORANDO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCHAPA = new javax.swing.JTextField();
        txtPESQUISA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtORIGEM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDESTINO = new javax.swing.JTextField();
        txtOBSERVACAO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnGerarTXT = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnADDAOTXT = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstITENS = new javax.swing.JList();
        btnEnviarDados = new javax.swing.JButton();
        txtMENSAGEM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERAR ARQUIVO TXT PARA ENVIO DE PATRIMONIOS PARA OUTRA UNIDADE");
        getContentPane().setLayout(null);

        jBoxPesquisar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jBoxPesquisar1.setName("panelDados"); // NOI18N

        txtMEMORANDO.setEditable(false);
        txtMEMORANDO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMEMORANDO.setForeground(new java.awt.Color(51, 51, 255));

        jLabel6.setText("MEMORANDO");

        jLabel1.setText("CHAPA");

        txtCHAPA.setEditable(false);
        txtCHAPA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCHAPA.setForeground(new java.awt.Color(51, 51, 255));
        txtCHAPA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCHAPAFocusGained(evt);
            }
        });
        txtCHAPA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCHAPAMouseClicked(evt);
            }
        });
        txtCHAPA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCHAPAKeyPressed(evt);
            }
        });

        txtPESQUISA.setEditable(false);
        txtPESQUISA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPESQUISA.setForeground(new java.awt.Color(51, 51, 255));
        txtPESQUISA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPESQUISAFocusGained(evt);
            }
        });
        txtPESQUISA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPESQUISAMouseClicked(evt);
            }
        });
        txtPESQUISA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPESQUISAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPESQUISAKeyReleased(evt);
            }
        });

        jLabel4.setText("OBSERVAÇÃO PARA MEMORANDO");

        txtORIGEM.setEditable(false);
        txtORIGEM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtORIGEM.setForeground(new java.awt.Color(51, 51, 255));
        txtORIGEM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtORIGEMFocusGained(evt);
            }
        });
        txtORIGEM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtORIGEMMouseClicked(evt);
            }
        });

        jLabel7.setText("ORIGEM");

        jLabel9.setText("DESTINO");

        txtDESTINO.setEditable(false);
        txtDESTINO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDESTINO.setForeground(new java.awt.Color(51, 51, 255));
        txtDESTINO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDESTINOFocusGained(evt);
            }
        });
        txtDESTINO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDESTINOMouseClicked(evt);
            }
        });
        txtDESTINO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDESTINOKeyPressed(evt);
            }
        });

        txtOBSERVACAO.setEditable(false);
        txtOBSERVACAO.setForeground(new java.awt.Color(51, 51, 255));
        txtOBSERVACAO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOBSERVACAOFocusGained(evt);
            }
        });

        jLabel5.setText("SERIE / CHAPA");

        javax.swing.GroupLayout jBoxPesquisar1Layout = new javax.swing.GroupLayout(jBoxPesquisar1);
        jBoxPesquisar1.setLayout(jBoxPesquisar1Layout);
        jBoxPesquisar1Layout.setHorizontalGroup(
            jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addComponent(txtMEMORANDO)
                        .addGap(10, 10, 10)
                        .addComponent(txtORIGEM, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDESTINO, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtOBSERVACAO, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(jLabel7)
                                .addGap(283, 283, 283)
                                .addComponent(jLabel9))
                            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(417, 417, 417)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(337, 337, 337)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addComponent(txtPESQUISA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCHAPA, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jBoxPesquisar1Layout.setVerticalGroup(
            jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtORIGEM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDESTINO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtMEMORANDO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPESQUISA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBoxPesquisar1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCHAPA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtOBSERVACAO, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jBoxPesquisar1.setLayer(txtMEMORANDO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtCHAPA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtPESQUISA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtORIGEM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtDESTINO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtOBSERVACAO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnGerarTXT.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnGerarTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TICK.PNG"))); // NOI18N
        btnGerarTXT.setText("Gerar TXT");
        btnGerarTXT.setToolTipText("");
        btnGerarTXT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGerarTXT.setEnabled(false);
        btnGerarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarTXTActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_limpar.gif"))); // NOI18N
        btnLimpar.setText("Cancelar");
        btnLimpar.setToolTipText("");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_sair.gif"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setToolTipText("");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_blocoNotas.gif"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnADDAOTXT.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnADDAOTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_Ok1.gif"))); // NOI18N
        btnADDAOTXT.setText("ADD ao TXT");
        btnADDAOTXT.setToolTipText("");
        btnADDAOTXT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnADDAOTXT.setEnabled(false);
        btnADDAOTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDAOTXTActionPerformed(evt);
            }
        });

        btnRemoverItem.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_Cancelar.gif"))); // NOI18N
        btnRemoverItem.setText("Remover Item");
        btnRemoverItem.setToolTipText("");
        btnRemoverItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoverItem.setEnabled(false);
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        lstITENS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lstITENS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstITENSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstITENS);

        btnEnviarDados.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnEnviarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_Ok.gif"))); // NOI18N
        btnEnviarDados.setText("Ler TXT Enviar");
        btnEnviarDados.setToolTipText("");
        btnEnviarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviarDados.setEnabled(false);
        btnEnviarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarDadosActionPerformed(evt);
            }
        });

        txtMENSAGEM.setEditable(false);
        txtMENSAGEM.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPANELTOTALLayout = new javax.swing.GroupLayout(jPANELTOTAL);
        jPANELTOTAL.setLayout(jPANELTOTALLayout);
        jPANELTOTALLayout.setHorizontalGroup(
            jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPANELTOTALLayout.createSequentialGroup()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGerarTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnADDAOTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPANELTOTALLayout.createSequentialGroup()
                .addGroup(jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBoxPesquisar1)
                    .addComponent(jScrollPane1)
                    .addComponent(txtMENSAGEM))
                .addGap(10, 10, 10))
        );
        jPANELTOTALLayout.setVerticalGroup(
            jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPANELTOTALLayout.createSequentialGroup()
                .addComponent(jBoxPesquisar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMENSAGEM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerarTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnADDAOTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPANELTOTAL);
        jPANELTOTAL.setBounds(14, 11, 1020, 650);

        setSize(new java.awt.Dimension(1055, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Leitura() 
    {  
        limpar();      
    }        
        
    private void addItensAoTXT()
    {  
        sChapa     = txtCHAPA.getText();
        sSerie     = txtPESQUISA.getText();
        sStatus    = "INATIVO";
        sSecaoid   = "30";
        sClienteid = "202";
        codSecao   = 30;
        codCliente = 202;
        sOrigem    = txtORIGEM.getText();
        sDestino   = txtDESTINO.getText();
        sMemorando = txtMEMORANDO.getText();
        
        iTipoid  = umMetodo.getCodigoPassandoString("tbltipos", "tipo", sTipo);
        sCodigo  = String.valueOf(codPatr);
        
        if(umMetodo.Emicro(codPatr)){
            sEstacao = "PGMCGGMC000";
        }else{
            sEstacao = umMetodo.getStringPassandoCodigo("tblpatrimonios", "estacao", codPatr);
        }
        
        sMotivo      = dataDoDia+" : Transferido de "+sOrigem+" para "+sDestino+" através do Memorando "+sMemorando+"";
        sObservacoes = dataDoDia+" : Transferido de "+sOrigem+" para "+sDestino+" através do Memorando "+sMemorando+"";
        
        //adicionando item na lista    
        String dados = sCodigo+";" +sEstacao+";"+sSecaoid+";"+sClienteid+";"+sStatus; 
        String item  = dados;           
        model.addElement(item);
        lstITENS.setModel(model);
               
        txtPESQUISA.setText("");
        txtPESQUISA.requestFocus();    
    }    
    
    private void btnGerarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarTXTActionPerformed
       //Metodo MANUAL inserido a série inteira
       for(int i = 0; i < model.size(); i++)
       {
            lstAuxiliar.add(model.get(i).toString());
       }
       
       objGerarTXT.gerarTXTDELISTA(lstAuxiliar); 
       gerarMemorandoDeEnvio();  
       
       limpar();      
       btnEnviarDados.setEnabled(true);
       btnGerarTXT.setEnabled(false);
       btnSair.setEnabled(true);
       inserindo=false;                   
                            
    }//GEN-LAST:event_btnGerarTXTActionPerformed

    private void exclusaoDeItensDoMemoCancelado()
    {
        sMemorando = txtMEMORANDO.getText();        
        umMetodo.deletarItensDoMemorando(sMemorando);
        umMetodo.excluirMemorandoSemItens();        
        limpar();
        btnLimpar.setEnabled(false);
    }
    
    private void limpar(){
        btnNovo.setEnabled(true);
        btnSair.setEnabled(true);
        btnGerarTXT.setEnabled(false);
        btnADDAOTXT.setEnabled(false);
        txtPESQUISA.setEditable(false);
        txtORIGEM.setEditable(false);
        txtDESTINO.setEditable(false);
        btnLimpar.setEnabled(false);
        btnRemoverItem.setEnabled(false);
        txtORIGEM.setText("");
        txtMEMORANDO.setText("");
        txtMENSAGEM.setText("");
        txtDESTINO.setText("");
        txtCHAPA.setText("");
        txtPESQUISA.setText("");      
        txtOBSERVACAO.setText("");      
        lstListaCampos.clear();
        model.clear();
        inserindo=false;        
    }
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //Este é o botão de cancelamento da operação
        exclusaoDeItensDoMemoCancelado();
        txtMENSAGEM.setText("");
        btnSair.setEnabled(true);    
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed
    
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //abrir lista de tipos de equipamentos para cadastrar
        inserindo=true;
        
        String proxMemo = String.valueOf(umMetodo.gerarProximoNumeroMemoTransferir()+"/"+anoVigente);
        txtMEMORANDO.setText(proxMemo);
        txtMENSAGEM.setText("Digite o destino dos equipamentos...");
        txtORIGEM.setText("CGGM/INFO");
        txtDESTINO.requestFocus();        
               
        //habilitando edição do txtSerie         
        txtOBSERVACAO.setEditable(true);        
        txtORIGEM.setEditable(true);        
        txtDESTINO.setEditable(true);        
        txtPESQUISA.setEditable(true);    
        btnNovo.setEnabled(false);        
        btnLimpar.setEnabled(true);
        btnGerarTXT.setEnabled(false);
        valorItem=0;
        lstAuxiliar.clear();
        model.clear();
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnADDAOTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDAOTXTActionPerformed
        if(!txtOBSERVACAO.getText().equals(""))
        {
            sObsMemo = umMetodo.primeiraLetraMaiuscula(txtOBSERVACAO.getText());
        }
                           
        if(txtPESQUISA.getText().equals("") || txtDESTINO.getText().equals("")|| txtCHAPA.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "OS campos [Destino] e [Série] são de preenchimento obrigatório!", "Campo obrigatório vazio!", 2);
            txtDESTINO.requestFocus();
        }else{       
            addItensAoTXT();     
            txtCHAPA.setText("");   
            btnSair.setEnabled(false);             
        }
        inseriuItem = true;
        btnGerarTXT.setEnabled(true);   

        //Grava itens no banco com status PROCESSANDO
        gravarItensNoBanco();
        btnADDAOTXT.setEnabled(false);
        
        btnSair.setEnabled(false);   
        txtMENSAGEM.setText("Digite a chapa ou série do equipamento e tecle <ENTER>");       
    }//GEN-LAST:event_btnADDAOTXTActionPerformed

    private void txtPESQUISAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPESQUISAKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCHAPA.requestFocus();
            txtCHAPA.selectAll();
            buscarNumeroChapaSerie();
            btnADDAOTXT.setEnabled(true);
            txtMENSAGEM.setText("Clique no botão ADD ao TXT para adicionar este equipamento ao memorando");
            if(umMetodo.temDuplicidadeDeCadastroNoMemorando("TBLITENSMEMOTRANSFERIDOS", "serie", txtPESQUISA.getText(),"numemo",txtMEMORANDO.getText() ))               
            {
                JOptionPane.showMessageDialog(null, "Ops esse equipamento já foi incluído nesse Memorando!", "Duplicidade de entrada!", 2); 
                btnADDAOTXT.setEnabled(false);
                txtCHAPA.setText("");
                txtPESQUISA.setText("");
                txtPESQUISA.requestFocus();
                btnGerarTXT.setEnabled(true);   
            }
        }        
        
    }//GEN-LAST:event_txtPESQUISAKeyPressed

    private void removerItem(){
        model.remove(codItem);       
        btnRemoverItem.setEnabled(false);
        btnADDAOTXT.setEnabled(false);
        txtPESQUISA.requestFocus();
        valorItem--;
    }    
    
    private int getCodigoChapaSerie()
    {
        //metodo retorna o código da chapa ou serie digitada
        sSerie  = txtPESQUISA.getText();
        sChapa  = txtPESQUISA.getText();
        
        int Result = umMetodo.getCodigoPassandoString("tblpatrimonios", "serie", sSerie);  
        //JOptionPane.showMessageDialog(null, Result);
        
        if(Result == 0)
        {
            Result = umMetodo.getCodigoPassandoString("tblpatrimonios", "chapa", sChapa);  
        }
        return Result;
    }
       
    private void buscarNumeroChapaSerie(){        
        //recebendo o codigo da chapa ou serie digitada
        codPatr = getCodigoChapaSerie();     
        getDados = umDaoPatri.getChapaSeriePeloCodigoDAO(codPatr);       
       
       if(valorPesquisaTrue){           
           txtPESQUISA.setText(getDados[0]);
           txtCHAPA.setText(getDados[1]);           
           btnADDAOTXT.setEnabled(true);
       }else{
           btnADDAOTXT.setEnabled(false);
           JOptionPane.showMessageDialog(null, "Atenção série/chapa não encontrada, verifique!","Série não encontrada!",2); 
           txtPESQUISA.setText("");
           txtCHAPA.setText("");
           txtPESQUISA.requestFocus();           
       }              
       
    }
    
    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        removerItem();
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void lstITENSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstITENSMouseClicked
        codItem = lstITENS.getSelectedIndex();  
        if(inseriuItem){
           btnRemoverItem.setEnabled(true);
        }       
    }//GEN-LAST:event_lstITENSMouseClicked

    private void atualizarStatusEquipamentos()
    {        
        //setando os valores no objeto do modelo  
        String Motivobd = umMetodo.getStringPassandoCodigo("tblpatrimonios", "motivo", codPatr);
        String Obsbd    = umMetodo.getStringPassandoCodigo("tblpatrimonios", "observacoes", codPatr);
        
        umModPatrimonio.setCodigo(Integer.valueOf(sCodigo));
        umModPatrimonio.setEstacao(sEstacao);
        umModPatrimonio.setSecaoid(Integer.valueOf(sSecaoid));
        umModPatrimonio.setClienteid(Integer.valueOf(sClienteid));
        umModPatrimonio.setStatus(sStatus);    
        umModPatrimonio.setDatainativacao(dataDia);
        
        umModPatrimonio.setMotivo(Motivobd+"\n"+sdf.format(dataDia)+" : Transferido de "+sOrigem+" para "+sDestino+" atraves do Memorando n. "+sMemorando+"."); 
        umModPatrimonio.setObservacoes(Obsbd+"\n"+sdf.format(dataDia)+" : Transferido de "+sOrigem+" para "+sDestino+" atraves do Memorando n. "+sMemorando+".");

        if (umControlePatrimonio.AtualizarPatrimoniosEncaminhados(umModPatrimonio)) {
            contador = 1;            
            umGravarLog.gravarLog("envio de equipamentos para "+sDestino+" atraves do Memorando n. "+sMemorando);
        }
        btnEnviarDados.setEnabled(false);
        
    }
    
    private void LexEncaminharTXT()
    {
        //inicializando as variaveis dos campos a serem gravados
        int totalLinhas = 0;
        RetornarQdeLinhasDoTxt qdeLinhas = new RetornarQdeLinhasDoTxt();

        //setando o caminho do arquivo TXT no edit do formulario apenas para mostrar o arquivo que esta sendo importado
        SelecionarArquivoTexto select = new SelecionarArquivoTexto();
        caminhoTXT = select.ImportarTXT();

        if (caminhoTXT != null) {
            totalLinhas = qdeLinhas.retornaNumLinhasDoTxt(caminhoTXT);
             //JOptionPane.showMessageDialog(null, "Qde de linhas do arquivo...: "+String.valueOf(totalLinhas));

            //criando uma variavel arquivo do tipo File e setando o caminho do arquivo TXT nela
            File arquivo = new File(caminhoTXT);
            try {
                FileReader ler        = new FileReader(arquivo);
                BufferedReader lerBuf = new BufferedReader(ler);
                linha                 = lerBuf.readLine();
                                                   
                while (linha != null) 
                {
                    sCodigo             = linha.split(";")[0]; 
                    sEstacao            = linha.split(";")[1];
                    sSecaoid            = linha.split(";")[2];
                    sClienteid          = linha.split(";")[3];
                    sStatus             = linha.split(";")[4];
                  
                    //Grava as alterações dos equipamentos a respeito do encaminhamento
                    atualizarStatusEquipamentos();
                                       
                    //lendo a proxima linha
                    linha = lerBuf.readLine();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar ler o arquivo!");
            }
            if (contador > 0) {
                JOptionPane.showMessageDialog(null, "Todos os patrimônios foram encaminhados com sucesso para "+sDestino+"!", "Encaminhados com sucesso para "+sDestino+"!", 2);                
            } else if (contador == 0) {                
                JOptionPane.showMessageDialog(null, "ERRO  no  cadastro  de  alguns registros, possíveis  causas :  Problemas  na  leitura do arquivo TXT\nou  duplicidade  em   algum   número  de   série   inserido,  confira  os   dados  do  TXT  selecionado!", "ERRO no cadastro!", 2);                                
            }
        }else{               
            btnGerarTXT.setEnabled(false);
            btnEnviarDados.setEnabled(false);
            btnLimpar.setEnabled(false);     
        }   
        imprimirRelatorio();        
        //atualizando tabela de ÍTENS ( TBLITENSMEMOTRANSFERIDOS ) do memorando de PROSSESANDO para TRANSFERIDO
        umMetodo.atualizarStatusParaTransferidos();                
    }
    
    private void gravarItensNoBanco() 
    {        
        //GRAVA O REGISTRO SELECIONADO NA TABELA TBLITENSMEMOTRANSFERIDOS PARA POSTERIOR IMPRESSAO  
        sstatusItem            = "PROCESSANDO";        
                       
        //SETANDO OS VALORES NO MODELO PARA GRAVAR
        valorItem++;
        objModPatriTemTransferido.setItem(valorItem);
        objModPatriTemTransferido.setNumemo(sMemorando);
        
        //Preciso entrar com o codigo do modelo
        //getDados = umDaoPatri.getChapaSeriePeloCodigoDAO(codPatr);  
        codMOdelo =  Integer.valueOf(getDados[2]);  
        objModPatriTemTransferido.setModeloid(codMOdelo);    
        objModPatriTemTransferido.setSerie(sSerie);
        objModPatriTemTransferido.setChapa(sChapa);      
        objModPatriTemTransferido.setOrigem(sOrigem);     
        objModPatriTemTransferido.setDestino(sDestino);     
        objModPatriTemTransferido.setStatus(sstatusItem);
        
        ctrlPatriTenstransferido.salvarPatriItensTransferido(objModPatriTemTransferido);        
              
    }
    
    private void gerarMemorandoDeEnvio(){                  
        
        /*QDO CLICA NO BOTAO ADICIONAR ABRE-SE A LISTA DE PATRIMONIOS E AO ESCOLHER UM ITEM O MESMO É INCLUIDO NA TBLITENSMEMOTRANSFERIDOS COM STATUS 
          PROCESSANDO MAS SÓ SERÁ GRAVADO SE GERAR O RELATORIO ATRAVES DO BOTAO IMPRIMIR, SE SAIR SEM GERAR O RELATORIO O MEMO E ÍTENS SERÃO EXCLUIDOS*/
                
        //SE O NUMERO DO MEMORANDO ESTIVER PREENCHIDO - NOSSO CABEÇALHO
        if(!txtMEMORANDO.getText().isEmpty() || !txtORIGEM.getText().isEmpty() || !txtDESTINO.getText().isEmpty()){
            
            //GERANDO NUMERO DO MEMO COM O ANO VIGENTE
            numMemoTransferido     = txtMEMORANDO.getText();
            origemTransferidos     = txtORIGEM.getText();
            destinoTransferidos    = txtDESTINO.getText();
            sMemoobservacao        = txtOBSERVACAO.getText();
            
            /*salvando memorando em definitivo ( TBLMEMOSTRANSFERIDOS ) apos gerar o relatorio  
              Nao deixar salvar quando clicado mais de uma vez / So gravar a primeira vez que clicar*/            
            if(!umMetodo.temDuplicidadeDeCadastro("TBLMEMOSTRANSFERIDOS", "numemo", numMemoTransferido))
            {
                umModPatriTransferido.setNumemo(numMemoTransferido);
                
                if(!sMemoobservacao.equals(null) && !sMemoobservacao.equals(""))
                {
                    umModPatriTransferido.setObservacao("Obs : "+umMetodo.primeiraLetraMaiuscula(sMemoobservacao));
                }else{
                    umModPatriTransferido.setObservacao(" ");
                }
                
                umModPatriTransferido.setStatus("TRANSFERIDO");
                umModPatriTransferido.setIdusuario(codigoUsuario);
                umCtrlPatriTranferido.salvarPatriTransferido(umModPatriTransferido); 
                umGravarLog.gravarLog("cadastro do memo de transferencia de patrimonios "+numMemoTransferido);
            }
        }
    }
    
    private void imprimirRelatorio(){
        
        if (umMetodo.ConfirmouOperacao("Confirma a impressão do Relatório?", "Impressão do Relatório"))
        {
            GerarRelatorios objRel = new GerarRelatorios();
            try {
                objRel.imprimirPatrimoniosTransferidos("relatorio/relmemotransferidos.jasper");
                umGravarLog.gravarLog("Impressao do Memo de Transferencia "+sMemorando);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!\n"+e);                
            }              
        }                
       
    }
    
    private void btnEnviarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarDadosActionPerformed
        LexEncaminharTXT();   
    }//GEN-LAST:event_btnEnviarDadosActionPerformed

    private void txtORIGEMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtORIGEMMouseClicked
        txtORIGEM.selectAll();
    }//GEN-LAST:event_txtORIGEMMouseClicked

    private void txtORIGEMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtORIGEMFocusGained
        txtORIGEM.selectAll();
    }//GEN-LAST:event_txtORIGEMFocusGained

    private void txtDESTINOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDESTINOKeyPressed
        //se teclar enter estando dentro do txtNOME vá para o campo do rf
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPESQUISA.requestFocus();
        }   
    }//GEN-LAST:event_txtDESTINOKeyPressed

    private void txtDESTINOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDESTINOMouseClicked
        txtDESTINO.selectAll();
    }//GEN-LAST:event_txtDESTINOMouseClicked

    private void txtDESTINOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDESTINOFocusGained
        txtDESTINO.selectAll();
        txtMENSAGEM.setText("Digite o destino dos equipamentos...");
    }//GEN-LAST:event_txtDESTINOFocusGained

    private void txtPESQUISAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPESQUISAMouseClicked
        txtPESQUISA.selectAll();
    }//GEN-LAST:event_txtPESQUISAMouseClicked

    private void txtPESQUISAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPESQUISAFocusGained
        txtPESQUISA.selectAll();
        txtMENSAGEM.setText("Digite a chapa ou série do equipamento e tecle <ENTER>");
    }//GEN-LAST:event_txtPESQUISAFocusGained

    private void txtCHAPAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCHAPAFocusGained
        txtCHAPA.selectAll();
    }//GEN-LAST:event_txtCHAPAFocusGained

    private void txtCHAPAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCHAPAMouseClicked
        txtCHAPA.selectAll();
    }//GEN-LAST:event_txtCHAPAMouseClicked

    private void txtPESQUISAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPESQUISAKeyReleased
        btnGerarTXT.setEnabled(false);
    }//GEN-LAST:event_txtPESQUISAKeyReleased

    private void txtCHAPAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCHAPAKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtOBSERVACAO.requestFocus();
        }        
    }//GEN-LAST:event_txtCHAPAKeyPressed

    private void txtOBSERVACAOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOBSERVACAOFocusGained
       txtMENSAGEM.setText("Digite uma observação que constará no memorando...");
    }//GEN-LAST:event_txtOBSERVACAOFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXTENVIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXTENVIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXTENVIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXTENVIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                F_GERARTXTENVIO dialog = new F_GERARTXTENVIO(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADDAOTXT;
    private javax.swing.JButton btnEnviarDados;
    private javax.swing.JButton btnGerarTXT;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSair;
    private javax.swing.JLayeredPane jBoxPesquisar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPANELTOTAL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstITENS;
    private javax.swing.JTextField txtCHAPA;
    private javax.swing.JTextField txtDESTINO;
    private javax.swing.JTextField txtMEMORANDO;
    private javax.swing.JTextField txtMENSAGEM;
    private javax.swing.JTextField txtOBSERVACAO;
    private javax.swing.JTextField txtORIGEM;
    private javax.swing.JTextField txtPESQUISA;
    // End of variables declaration//GEN-END:variables
}
