<?php

namespace Freelance\GrapheBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Ob\HighchartsBundle\Highcharts\Highchart;
use Zend\Json\Expr;

class GrapheController extends Controller {
 public function StatistiquePaysAction()
    {
        return $this->render('FreelanceGrapheBundle:Graphe:StatistiquePays.html.twig');
    }
    public function StatistiqueProjetAction()
    {
        return $this->render('FreelanceGrapheBundle:Graphe:StatistiqueProjet.html.twig');
    }
    public function chartLinePaysAction() {
        // ChartLine
        $em = $this->getDoctrine()
                ->getManager()
                ->getRepository('FreelanceFrontOfficeBundle:Membre');

        $Tqb = $em->createQueryBuilder('a');
        $Tqb->select('COUNT(a)');
        $Tqb->where('a.pays = :pays');
        $Tqb->setParameter('pays', "tunisie");

        $Tunisie = $Tqb->getQuery()->getSingleScalarResult();
        $Tun = intval($Tunisie);


        $Fqb = $em->createQueryBuilder('a');
        $Fqb->select('COUNT(a)');
        $Fqb->where('a.pays = :pays');
        $Fqb->setParameter('pays', "france");

        $France = $Fqb->getQuery()->getSingleScalarResult();
        $Fra = intval($France);


        $Aqb = $em->createQueryBuilder('a');
        $Aqb->select('COUNT(a)');
        $Aqb->where('a.pays = :pays');
        $Aqb->setParameter('pays', "amerique");

        $Amerique = $Aqb->getQuery()->getSingleScalarResult();
        $Ame = intval($Amerique);


        $Cqb = $em->createQueryBuilder('a');
        $Cqb->select('COUNT(a)');
        $Cqb->where('a.pays = :pays');
        $Cqb->setParameter('pays', "canada");

        $Canada = $Cqb->getQuery()->getSingleScalarResult();

        $Can = intval($Canada);

        $Iqb = $em->createQueryBuilder('a');
        $Iqb->select('COUNT(a)');
        $Iqb->where('a.pays = :pays');
        $Iqb->setParameter('pays', "italie");

        $Italie = $Iqb->getQuery()->getSingleScalarResult();
        $Ita = intval($Italie);


        $series = array(
            array("name" => "Nombre d'utilisateurs par pays ", "data" => array($Tun, $Fra, $Ame, $Can, $Ita))
        );

        $ob = new Highchart();
        $ob->chart->renderTo('linechart');  //  #id du div où afficher le graphe
        $ob->title->text("Nombre d'utilisateurs par pays");


        $ob->xAxis->title(array('text' => "Nom du pays"));
        $ob->yAxis->title(array('text' => "Nombre D'utilisateurs "));
        $ob->series($series);

        return $this->render('FreelanceGrapheBundle:Graphe:LineChart.html.twig', array(
                    'chart' => $ob
        ));
    }

    //Histogramme
    public function ChartHistogrammePaysAction() {
        $em = $this->getDoctrine()
                ->getManager()
                ->getRepository('FreelanceFrontOfficeBundle:Membre');

        $Tqb = $em->createQueryBuilder('a');
        $Tqb->select('COUNT(a)');
        $Tqb->where('a.pays = :pays');
        $Tqb->setParameter('pays', "tunisie");

        $Tunisie = $Tqb->getQuery()->getSingleScalarResult();
        $Tun = intval($Tunisie);


        $Fqb = $em->createQueryBuilder('a');
        $Fqb->select('COUNT(a)');
        $Fqb->where('a.pays = :pays');
        $Fqb->setParameter('pays', "france");

        $France = $Fqb->getQuery()->getSingleScalarResult();
        $Fra = intval($France);


        $Aqb = $em->createQueryBuilder('a');
        $Aqb->select('COUNT(a)');
        $Aqb->where('a.pays = :pays');
        $Aqb->setParameter('pays', "amerique");

        $Amerique = $Aqb->getQuery()->getSingleScalarResult();
        $Ame = intval($Amerique);


        $Cqb = $em->createQueryBuilder('a');
        $Cqb->select('COUNT(a)');
        $Cqb->where('a.pays = :pays');
        $Cqb->setParameter('pays', "canada");

        $Canada = $Cqb->getQuery()->getSingleScalarResult();

        $Can = intval($Canada);

        $Iqb = $em->createQueryBuilder('a');
        $Iqb->select('COUNT(a)');
        $Iqb->where('a.pays = :pays');
        $Iqb->setParameter('pays', "italie");

        $Italie = $Iqb->getQuery()->getSingleScalarResult();
        $Ita = intval($Italie);




        $series = array(
            array(
                'name' => 'Nombre utilisateur par pays',
                'type' => 'column',
                'color' => '#4572A7',
                'data' => array($Fra, $Tun, $Ame, $Can, $Ita),
            ),
            array(
                'name' => 'Nombre utilisateur  par pays',
                'type' => 'spline',
                'color' => '#AA4643',
                'data' => array($Fra, $Tun, $Ame, $Can, $Ita),
            ),
        );
        $yData = array(
            array(
                'labels' => array(
                    'formatter' => new Expr('function () { return this.value + " Utilisatuers" }'),
                    'style' => array('color' => '#AA4643')
                ),
                'title' => array(
                    'text' => 'Nombre utilisateur par pays',
                    'style' => array('color' => '#AA4643')
                ),
                'opposite' => true,
            ),
            array(
                'labels' => array(
                    'formatter' => new Expr('function () { return this.value + "Utilisateurs" }'),
                    'style' => array('color' => '#4572A7')
                ),
                'gridLineWidth' => 0,
                'title' => array(
                    'text' => 'Nombre utilisateur par pays',
                    'style' => array('color' => '#4572A7')
                ),
            ),
        );
        $categories = array('FRANCE', 'TUNISIE', 'AMERIQUE', 'CANADA', 'ITALIE');

        $ob = new Highchart();
        $ob->chart->renderTo('container'); // The #id of the div where to render the chart
        $ob->chart->type('column');
        $ob->title->text('Statistique des utilisateurs par pays ');
        $ob->xAxis->categories($categories);
        $ob->yAxis($yData);
        $ob->legend->enabled(false);
        $formatter = new Expr('function () {
                 var unit = {
                     "Rainfall": "Utilisateurs par pays",
                     "Temperature": "Utilisateurs par pays"
                 }[this.series.name];
                 return this.x + ": <b>" + this.y + "</b> " + unit;
             }');
        $ob->tooltip->formatter($formatter);
        $ob->series($series);
        return $this->render('FreelanceGrapheBundle:Graphe:Histogramme.html.twig', array(
                    'chart' => $ob
        ));
    }

    //pie
    public function chartPiePaysAction() {

        $em = $this->getDoctrine()
                ->getManager()
                ->getRepository('FreelanceFrontOfficeBundle:Membre');

        $Tqb = $em->createQueryBuilder('a');
        $Tqb->select('COUNT(a)');
        $Tqb->where('a.pays = :pays');
        $Tqb->setParameter('pays', "tunisie");

        $Tunisie = $Tqb->getQuery()->getSingleScalarResult();
        $Tun = intval($Tunisie);


        $Fqb = $em->createQueryBuilder('a');
        $Fqb->select('COUNT(a)');
        $Fqb->where('a.pays = :pays');
        $Fqb->setParameter('pays', "france");

        $France = $Fqb->getQuery()->getSingleScalarResult();
        $Fra = intval($France);


        $Aqb = $em->createQueryBuilder('a');
        $Aqb->select('COUNT(a)');
        $Aqb->where('a.pays = :pays');
        $Aqb->setParameter('pays', "amerique");

        $Amerique = $Aqb->getQuery()->getSingleScalarResult();
        $Ame = intval($Amerique);


        $Cqb = $em->createQueryBuilder('a');
        $Cqb->select('COUNT(a)');
        $Cqb->where('a.pays = :pays');
        $Cqb->setParameter('pays', "canada");

        $Canada = $Cqb->getQuery()->getSingleScalarResult();

        $Can = intval($Canada);

        $Iqb = $em->createQueryBuilder('a');
        $Iqb->select('COUNT(a)');
        $Iqb->where('a.pays = :pays');
        $Iqb->setParameter('pays', "italie");

        $Italie = $Iqb->getQuery()->getSingleScalarResult();
        $Ita = intval($Italie);


        $ob = new Highchart();
        $ob->chart->renderTo('piechart');
        $ob->title->text('Statistique des utilisateurs par pays');
        $ob->plotOptions->pie(array(
            'allowPointSelect' => true,
            'cursor' => 'pointer',
            'dataLabels' => array('enabled' => false),
            'showInLegend' => true
        ));
        $data = array(
            array('tunisie', $Tun),
            array('france', $Fra),
            array('amerique', $Ame),
            array('italie', $Ita),
            array('canada', $Can),
        );
        $ob->series(array(array('type' => 'pie', 'name' => 'Browser share', 'data' => $data)));
        return $this->render('FreelanceGrapheBundle:Graphe:pie.html.twig', array(
                    'chart' => $ob
        ));
    }
   //********************************************AllPays**************************
   
    
//*************************************************************Projet***********************/
    public function chartLineProjetAction() {
        $em = $this->getDoctrine()
                ->getManager()
                ->getRepository('FreelanceFrontOfficeBundle:Projet');

        $Java = $em->createQueryBuilder('a');
        $Java->select('COUNT(a)');
        $Java->where('a.categorie_p = :categorie_p');
        $Java->setParameter('categorie_p', "java");

        $Java = $Java->getQuery()->getSingleScalarResult();
        $JJ = intval($Java);

        $C = $em->createQueryBuilder('a');
        $C->select('COUNT(a)');
        $C->where('a.categorie_p = :categorie_p');
        $C->setParameter('categorie_p', "C#");

        $C = $C->getQuery()->getSingleScalarResult();
        $CC = intval($C);


        $ph = $em->createQueryBuilder('a');
        $ph->select('COUNT(a)');
        $ph->where('a.categorie_p = :categorie_p');
        $ph->setParameter('categorie_p', "photoshop");

        $ph = $ph->getQuery()->getSingleScalarResult();
        $PP = intval($ph);


        $web = $em->createQueryBuilder('a');
        $web->select('COUNT(a)');
        $web->where('a.categorie_p = :categorie_p');
        $web->setParameter('categorie_p', "web");

        $web= $web->getQuery()->getSingleScalarResult();

        $WW = intval($web);

        $phy = $em->createQueryBuilder('a');
        $phy->select('COUNT(a)');
        $phy->where('a.categorie_p = :categorie_p');
        $phy->setParameter('categorie_p', "phyton");

        $phy = $phy->getQuery()->getSingleScalarResult();
        $PPH = intval($phy);


        $series = array(
            array("name" => "Nombre de projet par categorie ", "data" => array($JJ, $CC, $PP, $WW, $PPH))
        );

        $ob = new Highchart();
        $ob->chart->renderTo('linechart');  //  #id du div où afficher le graphe
        $ob->title->text("Nombre de projet par categorie");


        $ob->xAxis->title(array('text' => "Nom du projet"));
        $ob->yAxis->title(array('text' => "Nombre categorie "));
        $ob->series($series);

        return $this->render('FreelanceGrapheBundle:Graphe:LineChart.html.twig', array(
                    'chart' => $ob
        ));
    }

    //Histogramme
    public function ChartHistogrammeProjetAction() {
         $em = $this->getDoctrine()
                ->getManager()
                ->getRepository('FreelanceFrontOfficeBundle:Projet');

        $Java = $em->createQueryBuilder('a');
        $Java->select('COUNT(a)');
        $Java->where('a.categorie_p = :categorie_p');
        $Java->setParameter('categorie_p', "java");

        $Java = $Java->getQuery()->getSingleScalarResult();
        $JJ = intval($Java);

        $C = $em->createQueryBuilder('a');
        $C->select('COUNT(a)');
        $C->where('a.categorie_p = :categorie_p');
        $C->setParameter('categorie_p', "C#");

        $C = $C->getQuery()->getSingleScalarResult();
        $CC = intval($C);


        $ph = $em->createQueryBuilder('a');
        $ph->select('COUNT(a)');
        $ph->where('a.categorie_p = :categorie_p');
        $ph->setParameter('categorie_p', "photoshop");

        $ph = $ph->getQuery()->getSingleScalarResult();
        $PP = intval($ph);


        $web = $em->createQueryBuilder('a');
        $web->select('COUNT(a)');
        $web->where('a.categorie_p = :categorie_p');
        $web->setParameter('categorie_p', "web");

        $web= $web->getQuery()->getSingleScalarResult();

        $WW = intval($web);

        $phy = $em->createQueryBuilder('a');
        $phy->select('COUNT(a)');
        $phy->where('a.categorie_p = :categorie_p');
        $phy->setParameter('categorie_p', "phyton");

        $phy = $phy->getQuery()->getSingleScalarResult();
        $PPH = intval($phy);

 $series = array(
            array(
                'name' => 'Nombre categorie',
                'type' => 'column',
                'color' => '#4572A7',
                'data' => array($JJ, $CC, $PP, $WW, $PPH),
            ),
            array(
                'name' => 'Nombre categorie',
                'type' => 'spline',
                'color' => '#AA4643',
                'data' => array($JJ, $CC, $PP, $WW, $PPH),
            ),
        );
        $yData = array(
            array(
                'labels' => array(
                    'formatter' => new Expr('function () { return this.value + " Utilisatuers" }'),
                    'style' => array('color' => '#AA4643')
                ),
                'title' => array(
                    'text' => 'Nombre de projet par categorie',
                    'style' => array('color' => '#AA4643')
                ),
                'opposite' => true,
            ),
            array(
                'labels' => array(
                    'formatter' => new Expr('function () { return this.value + "Utilisateurs" }'),
                    'style' => array('color' => '#4572A7')
                ),
                'gridLineWidth' => 0,
                'title' => array(
                    'text' => 'Nombre de projet par categorie',
                    'style' => array('color' => '#4572A7')
                ),
            ),
        );
        $categories = array('Java', 'C#', 'Photoshop', 'phyton', 'web');

        $ob = new Highchart();
        $ob->chart->renderTo('container'); // The #id of the div where to render the chart
        $ob->chart->type('column');
        $ob->title->text('Statistique des projets par categories ');
        $ob->xAxis->categories($categories);
        $ob->yAxis($yData);
        $ob->legend->enabled(false);
        $formatter = new Expr('function () {
                 var unit = {
                     "Rainfall": "projet",
                     "Temperature": "projet"
                 }[this.series.name];
                 return this.x + ": <b>" + this.y + "</b> " + unit;
             }');
        $ob->tooltip->formatter($formatter);
        $ob->series($series);
        return $this->render('FreelanceGrapheBundle:Graphe:Histogramme.html.twig', array(
                    'chart' => $ob
        ));
    }

    //pie
    public function chartPieProjetAction() {

         $em = $this->getDoctrine()
                ->getManager()
                ->getRepository('FreelanceFrontOfficeBundle:Projet');

        $Java = $em->createQueryBuilder('a');
        $Java->select('COUNT(a)');
        $Java->where('a.categorie_p = :categorie_p');
        $Java->setParameter('categorie_p', "java");

        $Java = $Java->getQuery()->getSingleScalarResult();
        $JJ = intval($Java);

        $C = $em->createQueryBuilder('a');
        $C->select('COUNT(a)');
        $C->where('a.categorie_p = :categorie_p');
        $C->setParameter('categorie_p', "C#");

        $C = $C->getQuery()->getSingleScalarResult();
        $CC = intval($C);


        $ph = $em->createQueryBuilder('a');
        $ph->select('COUNT(a)');
        $ph->where('a.categorie_p = :categorie_p');
        $ph->setParameter('categorie_p', "photoshop");

        $ph = $ph->getQuery()->getSingleScalarResult();
        $PP = intval($ph);


        $web = $em->createQueryBuilder('a');
        $web->select('COUNT(a)');
        $web->where('a.categorie_p = :categorie_p');
        $web->setParameter('categorie_p', "web");

        $web= $web->getQuery()->getSingleScalarResult();

        $WW = intval($web);

        $phy = $em->createQueryBuilder('a');
        $phy->select('COUNT(a)');
        $phy->where('a.categorie_p = :categorie_p');
        $phy->setParameter('categorie_p', "phyton");

        $phy = $phy->getQuery()->getSingleScalarResult();
        $PPH = intval($phy);



        $ob = new Highchart();
        $ob->chart->renderTo('piechart');
        $ob->title->text('Nombre de projet par categorie');
        $ob->plotOptions->pie(array(
            'allowPointSelect' => true,
            'cursor' => 'pointer',
            'dataLabels' => array('enabled' => false),
            'showInLegend' => true
        ));
        $data = array(
            array('Java', $JJ),
            array('C#', $CC),
          array('web#',  $WW),
            array('photoshop', $PP),
            array('phyton', $PPH),
        );
        $ob->series(array(array('type' => 'pie', 'name' => 'Browser share', 'data' => $data)));
        return $this->render('FreelanceGrapheBundle:Graphe:pie.html.twig', array(
                    'chart' => $ob
        ));
    }

}
