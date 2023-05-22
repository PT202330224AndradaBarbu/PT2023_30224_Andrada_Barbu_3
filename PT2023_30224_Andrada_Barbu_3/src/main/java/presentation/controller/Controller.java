package presentation.controller;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.CosBLL;
import bll.ProdusBLL;
import dao.AbstractDAO;
import model.*;
import presentation.view.*;
import utils.ClientUtils;
import utils.ProdusUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {

    private PrincipalGUI principalGUI;
    private ClientGUI clientGUI;
    private ProdusGUI produsGUI;
    private AdaugareClientGUI adaugareClientGUI;
    private AdaugareProdusGUI adaugareProdusGUI;
    private StergereProdusGUI stergereProdusGUI;
    private StergereClientGUI stergereClientGUI;
    private EditareProdusGUI editareProdusGUI;
    private EditareClientGUI editareClientGUI;

    private AfisareClientiGUI afisareClientiGUI;
    private AfisareProduseGUI afisareProduseGUI;

    private ComandaGUI comandaGUI;


    public Controller(PrincipalGUI principalaGUI, ClientGUI clientGUI, ProdusGUI produsGUI, AdaugareClientGUI adaugareClientGUI, AdaugareProdusGUI adaugareProdusGUI, StergereProdusGUI stergereProdusGUI, StergereClientGUI stergereClientGUI, EditareProdusGUI editareProdusGUI, EditareClientGUI editareClientGUI, AfisareClientiGUI afisareClientiGUI, AfisareProduseGUI afisareProduseGUI, ComandaGUI comandaGUI) {
        this.principalGUI = principalaGUI;
        this.principalGUI.addClientiListener(new ClientiListener());
        this.principalGUI.addCProduseListener(new ProduseListener());
        this.principalGUI.addComandaListener(new ComandaListener());

        this.clientGUI = clientGUI;
        this.clientGUI.addAdaugareClientListener(new AdaugareClientListener());
        this.adaugareClientGUI=adaugareClientGUI;
        this.adaugareClientGUI.addAdaugareClientFinalListener(new AdaugareClientFinalListener());
        this.adaugareClientGUI.addBackListener(new BackListenerAdaugareClient());


        this.clientGUI.addStergereClientListener(new StergereClientListener());
        this.stergereClientGUI = stergereClientGUI;
        this.stergereClientGUI.addStergereClinetFinalListener(new StergereClientFinalLintener());

        this.clientGUI.addEditareClientListener(new EditareClientListener());
        this.editareClientGUI=editareClientGUI;
        this.editareClientGUI.addEditareClientFinalListener(new EditareClientFinalLintener());
        this.editareClientGUI.addBackListener(new BackListenerEditareClient());

        this.clientGUI.addVizualizareClientiListener(new AfisareClientiListener());
        this.afisareClientiGUI = afisareClientiGUI;

        this.clientGUI.addBackListener(new BackListenerClient());

        this.produsGUI=produsGUI;
        this.produsGUI.addAdaugareProdusListener(new AdaugareProdusListener());
        this.adaugareProdusGUI=adaugareProdusGUI;
        this.adaugareProdusGUI.addAdaugareProdusFinalListener(new AdaugareProdusFinalListener());
        this.adaugareProdusGUI.addBackListener(new BackListenerAdaugareProdus());


        this.produsGUI.addStergereProdusListener(new StergereProdusListener());
        this.stergereProdusGUI=stergereProdusGUI;
        this.stergereProdusGUI.addStergereProdusFinalListener(new StergereProdusFinalLintener());

        this.produsGUI.addEditareProdusListener(new EditareProdusListener());
        this.editareProdusGUI=editareProdusGUI;
        this.editareProdusGUI.addEditareProdusFinalListener(new EditareProdusFinalLintener());
        this.editareProdusGUI.addBackListener(new BackListenerEditareProdus());

        this.produsGUI.addVizualizareProduseListener(new AfisareProduseListener());
        this.produsGUI.addBackListener(new BackListenerProdus());
        this.afisareProduseGUI = afisareProduseGUI;

        this.comandaGUI = comandaGUI;
        this.comandaGUI.addComandaNouaListener(new ComandaNouaListener());
        this.comandaGUI.addAdaugareProdusListener(new AdaugareProdusComandaListener());
        this.comandaGUI.addFinalizareComandaListener(new FinalizareComandaListener());
    }

    class ClientiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientGUI.setVisible(true);
        }
    }

    class ProduseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            produsGUI.setVisible(true);
        }
    }

    class ComandaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            comandaGUI.setTotal(0);
            comandaGUI.resetEmail();
            comandaGUI.setEmailTextEnabled(true);
            comandaGUI.resetProdus();
            comandaGUI.resetCantitate();
            ProdusBLL produsBLL = new ProdusBLL();
            List<Produs> produse = produsBLL.cautareProdus();
            ProdusUtils produsUtils = new ProdusUtils();
            String[] coloane = produsUtils.getHeader();
            String[][] randuri = produsUtils.getValues(produse);
            comandaGUI.actualizareTabelProdus(randuri, coloane);
            ClientBLL clientBLL = new ClientBLL();
            List<Client> clienti = clientBLL.cautareClienti();
            ClientUtils clientUtils = new ClientUtils();
            coloane = clientUtils.getHeader();
            randuri = clientUtils.getValues(clienti);
            comandaGUI.actualizareTabelClient(randuri, coloane);
            comandaGUI.setVisible(true);
        }
    }

    class ComandaNouaListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String email = "";
            try {
                email = comandaGUI.getEmail();
                ClientBLL clientBLL = new ClientBLL();
                Client client = clientBLL.cautareClientDupaEmail(email);
                Cos cos = new Cos(client.getId());
                CosBLL cosBLL = new CosBLL();
                cosBLL.inserareCos(cos);
                comandaGUI.setEmailTextEnabled(false);
            } catch (IllegalArgumentException ex1) {
                comandaGUI.aruncaEroare(ex1.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class AdaugareProdusComandaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String denumireProdus = "";
            String email = "";
            try{
                denumireProdus = comandaGUI.getProdus();
                int cantitate = Integer.parseInt(comandaGUI.getCantitate());
                ProdusBLL produsBLL = new ProdusBLL();
                Produs produs = produsBLL.cautareProdusDupaDenumire(denumireProdus);
                if (cantitate > produs.getCantitate()) {
                    comandaGUI.aruncaEroare("Stoc insuficient!");
                } else {
                    email = comandaGUI.getEmail();
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = clientBLL.cautareClientDupaEmail(email);
                    CosBLL cosBLL = new CosBLL();
                    Cos cos = cosBLL.cautareCosFinalizatDupaIdClient(client.getId(),0);
                    int total = cos.getTotal();
                    Comanda comanda = new Comanda(cos.getId(), produs.getId(), produs.getPretBuc(), cantitate);
                    ComandaBLL comandaBLL = new ComandaBLL();
                    comandaBLL.inserareComanda(comanda);
                    produs.setCantitate(produs.getCantitate() - cantitate);
                    total+=produs.getPretBuc() * cantitate;
                    cos.setTotal(total);
                    cosBLL.editareCos(cos);
                    produsBLL.editareProdus(produs);
                    comandaGUI.setTotal(cos.getTotal());
                    List<Produs> produse = produsBLL.cautareProdus();
                    ProdusUtils produsUtils = new ProdusUtils();
                    String[] coloane = produsUtils.getHeader();
                    String[][] randuri = produsUtils.getValues(produse);
                    comandaGUI.actualizareTabelProdus(randuri, coloane);
                }
            } catch (NumberFormatException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalArgumentException ex1) {
                comandaGUI.aruncaEroare(ex1.getMessage());
            }
        }
    }

    class FinalizareComandaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String email = "";
            try {
                email = comandaGUI.getEmail();
                ClientBLL clientBLL = new ClientBLL();
                Client client = clientBLL.cautareClientDupaEmail(email);
                CosBLL cosBLL = new CosBLL();
                Cos cos = cosBLL.cautareCosFinalizatDupaIdClient(client.getId(), 0);
                cos.setFinalizat(1);
                cosBLL.editareCos(cos);
                Bill bill = new Bill(client.getNume(), client.getEmail(), cos.getTotal());

                comandaGUI.setVisible(false);
                principalGUI.setVisible(true);
            } catch (IllegalArgumentException ex1) {
                comandaGUI.aruncaEroare(ex1.getMessage());
            }
        }
    }

    class AfisareClientiListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();
            List<Client> clienti = clientBLL.cautareClienti();
            ClientUtils clientUtils = new ClientUtils();
            String[] coloane = clientUtils.getHeader();
            String[][] randuri = clientUtils.getValues(clienti);
            afisareClientiGUI.actualizareTabel(randuri, coloane);
            afisareClientiGUI.setVisible(true);
        }
    }

    class AdaugareClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adaugareClientGUI.setVisible(true);
        }
    }

    class AdaugareClientFinalListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nume="";
            String telefon="";
            String email="";
            String adresa="";
            try {
                nume = adaugareClientGUI.getNumeInput();
                telefon = adaugareClientGUI.getTelefonInput();
                email = adaugareClientGUI.getEmailInput();
                adresa = adaugareClientGUI.getAdresaInput();
                Client client = new Client(nume, telefon, email, adresa);
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.inserareClient(client);
                adaugareClientGUI.setVisible(false);
                clientGUI.setVisible(true);
            }catch (IllegalArgumentException e1) {
                adaugareClientGUI.aruncaEroare(e1.getMessage());
            }

        }
    }

    class BackListenerAdaugareClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adaugareClientGUI.setVisible(false);
        }
    }
    class BackListenerEditareClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editareClientGUI.setVisible(false);
        }
    }

    class BackListenerClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientGUI.setVisible(false);
        }
    }
    class BackListenerProdus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            produsGUI.setVisible(false);
        }
    }

    class BackListenerStergereClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stergereClientGUI.setVisible(false);
        }
    }

    class BackListenerAdaugareProdus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adaugareProdusGUI.setVisible(false);
        }
    }
    class BackListenerEditareProdus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editareProdusGUI.setVisible(false);
        }
    }
    class BackListenerStergereProdus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stergereProdusGUI.setVisible(false);
        }
    }
    class EditareClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editareClientGUI.setVisible(true);
        }
    }

    class EditareClientFinalLintener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String email="";
            String nume="";
            String adresa="";
            String telefon="";
            String emailEditat="";

            try {
                emailEditat = editareClientGUI.getEditatInput();
                ClientBLL clientBLL = new ClientBLL();
                Client client = clientBLL.cautareClientDupaEmail(emailEditat);

                nume=editareClientGUI.getNumeInput();
                adresa=editareClientGUI.getAdresaInput();
                telefon=editareClientGUI.getTelefonInput();
                email=editareClientGUI.getEmailInput();

                if(nume != null && !nume.isEmpty()) {
                    client.setNume(nume);
                }
                if(adresa != null && !adresa.isEmpty()) {
                    client.setAdresa(adresa);
                }
                if(telefon != null && !telefon.isEmpty()) {
                    client.setTelefon(telefon);
                }

                if(email != null && !email.isEmpty()) {
                    client.setEmail(email);
                }
                clientBLL.editareClient(client);
                editareClientGUI.setVisible(false);
                clientGUI.setVisible(true);
            }catch (IllegalArgumentException e1) {
                editareClientGUI.aruncaEroare(e1.getMessage());
            }

        }
    }

    class StergereClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stergereClientGUI.setVisible(true);
        }
    }

    class StergereClientFinalLintener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String email="";

            try {
                email = stergereClientGUI.getEmailInput();
                ClientBLL clinetBLL = new ClientBLL();
                clinetBLL.stergereClient(email);
                stergereClientGUI.setVisible(false);
                clientGUI.setVisible(true);
            }catch (IllegalArgumentException e1) {
                System.out.println(e1.getMessage());
            }

        }
    }

    class AdaugareProdusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adaugareProdusGUI.setVisible(true);
        }
    }

    class AdaugareProdusFinalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String denumire="";
            String pretBuc="";
            String cantitate="";

            try {
                denumire = adaugareProdusGUI.getDenumireInput();
                pretBuc = adaugareProdusGUI.getPretbucInput();
                cantitate = adaugareProdusGUI.getCantitateInput();

                int pretBucInt = Integer.parseInt(pretBuc);
                int cantitateInt = Integer.parseInt(cantitate);
                Produs produs = new Produs(denumire, pretBucInt, cantitateInt);
                ProdusBLL produsBLL = new ProdusBLL();
                produsBLL.inserareProdus(produs);
                adaugareProdusGUI.setVisible(false);
                produsGUI.setVisible(true);
            }catch (IllegalArgumentException e1) {
                adaugareProdusGUI.aruncaEroare(e1.getMessage());
            }

        }
    }

    class StergereProdusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stergereProdusGUI.setVisible(true);
        }
    }

    class StergereProdusFinalLintener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String denumire="";

            try {
                denumire = stergereProdusGUI.getDenumireInput();
                ProdusBLL produsBLL = new ProdusBLL();
                produsBLL.stergereProdus(denumire);
                stergereProdusGUI.setVisible(false);
                produsGUI.setVisible(true);
            }catch (IllegalArgumentException e1) {
                System.out.println(e1.getMessage());
            }

        }
    }

    class EditareProdusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editareProdusGUI.setVisible(true);
        }
    }

    class EditareProdusFinalLintener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String denumireCautata="";
            String denumire="";
            String pretBuc="";
            String cantitate="";
            try {
                denumireCautata = editareProdusGUI.getDenumireeditatInput();
                ProdusBLL produsBLL = new ProdusBLL();
                Produs produs = produsBLL.cautareProdusDupaDenumire(denumireCautata);
                denumire = editareProdusGUI.getDenumireInput();
                pretBuc = editareProdusGUI.getPretbucInput();
                cantitate = editareProdusGUI.getCantitateInput();

                if(denumire != null && !denumire.isEmpty()) {
                    produs.setDenumire(denumire);
                }
                if(pretBuc != null && !pretBuc.isEmpty()) {
                    produs.setPretBuc(Integer.parseInt(pretBuc));
                }
                if(cantitate != null && !cantitate.isEmpty()) {
                    produs.setCantitate(Integer.parseInt(cantitate));
                }
                produsBLL.editareProdus(produs);
                editareProdusGUI.setVisible(false);
                produsGUI.setVisible(true);
            } catch (IllegalArgumentException e1) {
                editareProdusGUI.aruncaEroare(e1.getMessage());
            }
        }
    }

    class AfisareProduseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ProdusBLL produsBLL = new ProdusBLL();
            List<Produs> produse = produsBLL.cautareProdus();
            ProdusUtils produsUtils = new ProdusUtils();
            String[] coloane = produsUtils.getHeader();
            String[][] randuri = produsUtils.getValues(produse);
            afisareProduseGUI.actualizareTabel(randuri, coloane);
            afisareProduseGUI.setVisible(true);
        }
    }
}
