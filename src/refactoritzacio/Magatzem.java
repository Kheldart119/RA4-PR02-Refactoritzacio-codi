package refactoritzacio;

class Magatzem {

    /* Array que guarda tots els articles del magatzem */
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    /*
     * Recorre tots els articles
     * i actualitza el seu estat
     */
    public void actualitzarEstat() {

        for (int i = 0; i < articles.length; i++) {
            actualitzarArticle(articles[i]);
        }
    }

    /*
     * Comprova el tipus d'article
     * i crida el mètode corresponent
     */
    private void actualitzarArticle(Article article) {

        if (article.nom.equals("Martell de Thor (Llegendari)")) {

            actualitzarMartell(article);

        } else if (article.nom.equals("Formatge Gidurat")) {

            actualitzarFormatge(article);

        } else if (article.nom.equals("Entrades per al Concert del Trobador")) {

            actualitzarEntrades(article);

        } else {

            actualitzarArticleNormal(article);
        }
    }

    /*
     * Articles normals:
     * - la qualitat baixa cada dia
     * - quan caduca, baixa el doble
     */
    private void actualitzarArticleNormal(Article article) {

        if (article.qualitat > 0) {
            article.qualitat--;
        }

        article.diesPerVendre--;

        if (article.diesPerVendre < 0) {

            if (article.qualitat > 0) {
                article.qualitat--;
            }
        }
    }

    /*
     * El formatge augmenta la qualitat
     * amb el pas del temps
     */
    private void actualitzarFormatge(Article article) {

        if (article.qualitat < 50) {
            article.qualitat++;
        }

        article.diesPerVendre--;

        if (article.diesPerVendre < 0) {

            if (article.qualitat < 50) {
                article.qualitat++;
            }
        }
    }

    /*
     * Les entrades augmenten la qualitat
     * segons la proximitat del concert
     *
     * Després del concert la qualitat passa a 0
     */
    private void actualitzarEntrades(Article article) {

        if (article.qualitat < 50) {

            article.qualitat++;

            if (article.diesPerVendre < 11) {

                if (article.qualitat < 50) {
                    article.qualitat++;
                }
            }

            if (article.diesPerVendre < 6) {

                if (article.qualitat < 50) {
                    article.qualitat++;
                }
            }
        }

        article.diesPerVendre--;

        if (article.diesPerVendre < 0) {
            article.qualitat = 0;
        }
    }

    /*
     * El Martell és un article llegendari
     * i no modifica el seu estat
     */
    private void actualitzarMartell(Article article) {

    }
}