package refactoritzacio;

class Magatzem {

    /**
     * Constants amb els noms dels articles especials
     */
    private static final String FORMATGE = "Formatge Gidurat";
    private static final String ENTRADES = "Entrades per al Concert del Trobador";
    private static final String MARTELL = "Martell de Thor (Llegendari)";

    /**
     * Array que guarda tots els articles del magatzem
     */
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    /**
     * Recorre tots els articles
     * i actualitza el seu estat
     */
    public void actualitzarEstat() {

        for (int i = 0; i < articles.length; i++) {
            actualitzarArticle(articles[i]);
        }
    }

    /**
     * Comprova el tipus d'article
     * i crida el mètode corresponent
     */
    private void actualitzarArticle(Article article) {

        if (article.nom.equals(MARTELL)) {

            actualitzarMartell(article);

        } else if (article.nom.equals(FORMATGE)) {

            actualitzarFormatge(article);

        } else if (article.nom.equals(ENTRADES)) {

            actualitzarEntrades(article);

        } else {

            actualitzarArticleNormal(article);
        }
    }

    /**
     * Articles normals:
     * - la qualitat baixa cada dia
     * - quan caduca, baixa el doble
     */
    private void actualitzarArticleNormal(Article article) {

        baixarQualitat(article);

        article.diesPerVendre--;

        if (article.diesPerVendre < 0) {
            baixarQualitat(article);
        }
    }

    /**
     * El formatge augmenta la qualitat
     * amb el pas del temps
     */
    private void actualitzarFormatge(Article article) {

        pujarQualitat(article);

        article.diesPerVendre--;

        if (article.diesPerVendre < 0) {
            pujarQualitat(article);
        }
    }

    /**
     * Les entrades augmenten la qualitat
     * segons la proximitat del concert
     *
     * Després del concert la qualitat passa a 0
     */
    private void actualitzarEntrades(Article article) {

        pujarQualitat(article);

        if (article.diesPerVendre < 11) {
            pujarQualitat(article);
        }

        if (article.diesPerVendre < 6) {
            pujarQualitat(article);
        }

        article.diesPerVendre--;

        if (article.diesPerVendre < 0) {
            article.qualitat = 0;
        }
    }

    /**
     * El Martell és un article llegendari
     * i no modifica el seu estat
     */
    private void actualitzarMartell(Article article) {

    }

    /**
     * Augmenta la qualitat sense superar el màxim permès
     */
    private void pujarQualitat(Article article) {

        if (article.qualitat < 50) {
            article.qualitat++;
        }
    }

    /**
     * Redueix la qualitat sense baixar de 0
     */
    private void baixarQualitat(Article article) {

        if (article.qualitat > 0) {
            article.qualitat--;
        }
    }
}