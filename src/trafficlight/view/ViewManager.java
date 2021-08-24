package trafficlight.view;

import trafficlight.model.strategy.Kehl;
import trafficlight.model.strategy.Strasbourg;
import trafficlight.model.TrafficLight;
import trafficlight.view.decorator.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewManager extends JFrame{

    //Attributs
    private List<TrafficLightView> _viewsList = new ArrayList<TrafficLightView>();
    private TrafficLight _t;
    private static boolean _instancied = false;
    private JDesktopPane _jp;


    //Constructeurs Singleton
    private ViewManager(TrafficLight t){
        //On set le feu et on affiche la fenêtre
        _t = t;
        viewManagerWindow();
    }
    public static ViewManager newViewManager(TrafficLight t){
        if(!_instancied){
            _instancied = true;
            return new ViewManager(t);
        }
        else throw new ExceptionInInitializerError("SINGLETON : Une instance de ViewManager existe déjà !");
    }


    //Méthodes d'instances

    //Créer la fenêtre principale
    private void viewManagerWindow(){
        //On crée la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 480);
        this.setLayout(new BorderLayout());

        //On place la liste des vues
        JPanel vues = new JPanel();
        this.getContentPane().add(vues, BorderLayout.NORTH);

        //On place le bouton de changement de rive
        JPanel rive = new JPanel();
        this.getContentPane().add(rive, BorderLayout.WEST);
        JButton b = new JButton("Strasbourg");
        AbstractAction a = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (_t.getLoc() instanceof Kehl) {
                    _t.setLoc(new Strasbourg());
                    b.setText("Strasbourg");
                }
                else {
                    System.out.println("salut");
                    _t.setLoc(new Kehl());
                    b.setText("Kehl");
                }
            }
        };
        b.addActionListener(a);
        rive.add(b);


        //On place les boutons de création de vues
        JPanel buttons = new JPanel();
        buttons.add( new JButton( new AbstractAction("Nouvelle vue graphique") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                createView(0);
            }
        }));
        buttons.add( new JButton( new AbstractAction("Nouvelle vue pietonne") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                createView(1);
            }
        }));
        buttons.add( new JButton( new AbstractAction("Nouvelle vue \"Tourne à droite\"") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                createView(2);
            }
        }));
        buttons.add( new JButton( new AbstractAction("Nouvelle vue textuelle") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                createView(3);
            }
        }));
        this.getContentPane().add(buttons, BorderLayout.SOUTH);

        //On crée le JDesktopPane central
        JDesktopPane dp = new JDesktopPane();
        this._jp = dp;
        dp.setLayout(new GridLayout());
        this.getContentPane().add(dp, BorderLayout.CENTER);
        this.setVisible(true);
    }



    //On crée la vue (lors de l'appui sur les boutons)
    private void createView(int type){

        //On crée la vue
        String nom = "Vue n° :" + (_viewsList.size()+1);
        TrafficLightView view;
        ViewDecorator v;
        switch (type){
            default:
                nom += ": Textuelle";
                view = new TextualLight(_t, nom);
                v = new TextualDecorated(view);
                _t.add(v);
                break;
            case 0:
                nom += ": Graphique";
                view = new GraphicalLight(_t, nom);
                v = new NormalDecorated(view);
                _t.add(v);
                break;
            case 1:
                nom += ": Piéton";
                view = new GraphicalLight(_t, nom);
                v = new PedestrianDecorated(view);
                _t.add(v);
                break;
            case 2:
                nom += ": Fléche droite";
                view = new GraphicalLight(_t, nom);
                v = new LeftTurnDecorated(view);
                _t.add(v);
                break;
        }


        //On affiche la vue
        _jp.add(view);

        //On ajoute la vue à la liste des vues
        _viewsList.add(view); //Dans la liste
        addView(view);// Graphiquement
    }
    //Mise à jour de la liste des vues (graphiquement)
    private void addView(TrafficLightView view){
        //On trouve le jpanel vues
        Component vues = this.getContentPane().findComponentAt(1,1);
        JPanel vuesJ = (JPanel)vues;

        //On ajoute le bouton
        JButton b = new JButton(view.getName());
        AbstractAction a = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delView(view, b);
            }};
        b.addActionListener(a);
        b.setMinimumSize(new Dimension(100,100));
        vuesJ.add(b, BorderLayout.CENTER);




    }
    private void delView(TrafficLightView view, JButton b){

        //On supprime la vue
        //Du jDestop
        _jp.remove(view);

        //Le bouton
        Component vues = this.getContentPane().findComponentAt(1,1);
        JPanel vuesJ = (JPanel)vues;
        vuesJ.remove(b);

        //Dans la liste
        _viewsList.remove(view);

        //On update
        this.repaint();
        _jp.updateUI();
    }
}
