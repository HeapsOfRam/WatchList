/*
 * Show.java
 * Author: HeapsOfRam
 */
package watchlist;

public class Show implements Comparable{
    private int episode, totEpisodes;
    private boolean finished, movie;
    private String name;
    private int rating;
    
    public Show(String name){
        this.name = name;
        episode = 0;
        totEpisodes = 0;
        finished = false;
        movie = false;
        rating = 0;
    }
    
    public Show(String name, int episode){
        this.name = name;
        this.episode = episode;
        totEpisodes = 0;
        finished = false;
        movie = false;
        rating = 0;
    }
    
    public Show(int totEpisodes, String name){
        this.totEpisodes = totEpisodes;
        this.name = name;
        episode = 0;
        finished = false;
        movie = false;
        rating = 0;
    }
    
    public Show(String name, int episode, int totEpisodes){
        this.name = name;
        this.episode = episode;
        this.totEpisodes = totEpisodes;
        finished = false;
        movie = false;
        rating = 0;
    }
    
    public Show(String name, int episode, boolean finished){
        this.name = name;
        this.episode = episode;
        this.finished = finished;
        movie = false;
        totEpisodes = 0;
        rating = 0;
    }
    
    public Show(String name, boolean finished){
        this.name = name;
        this.finished = finished;
        movie = false;
        episode = 0;
        totEpisodes = 0;
        rating = 0;
    }
    
    public Show(boolean movie, String name){
        this.name = name;
        this.movie = movie;
        finished = false;
        episode = 1;
        totEpisodes = 1;
        rating = 0;
    }
    
    public Show(String name, int episode, int totEpisodes, boolean finished, int rating){
        this.name = name;
        this.episode = episode;
        this.totEpisodes = totEpisodes;
        this.finished = finished;
        this.rating = rating;
        movie = false;
    }
    
    public Show(String name, int episode, int totEpisodes, boolean finished, boolean movie, int rating){
        this.name = name;
        this.episode = episode;
        this.totEpisodes = totEpisodes;
        this.finished = finished;
        this.movie = movie;
        this.rating = rating;
    }
    
    public int compareTo(Object o){
        Show s = (Show) o;
        if(s.getName() == name)
            return 0;
        else
            return -1;
    }
    
    public boolean equals(Object o){
        Show s = (Show) o;
        if(s.getName() == name)
            return true;
        return false;
    }
    
    public void setName(String name)
    {this.name = name;}
    
    public void setEpisode(int episode)
    {this.episode = episode;}
    
    public void setTotEpisode(int totEpisodes)
    {this.totEpisodes = totEpisodes;}
    
    public void setFinished(boolean finished)
    {this.finished = finished;}
    
    public void setMovie(boolean movie)
    {this.movie = movie;}
    
    public void setRating(int rating)
    {this.rating = rating;}
    
    public String getName()
    {return name;}
    
    public int getEpisode()
    {return episode;}
    
    public int getTotEpisode()
    {return totEpisodes;}
    
    public boolean getFinished()
    {return finished;}
    
    public boolean getMovie()
    {return movie;}
    
    public int getRating()
    {return rating;}
    
    /*public String toString(){
        if(movie)
            return name + "\tStatus: " + finished;
        return name + " = Episode " + episode + " out of " + totEpisodes + "\tRATING: " + rating;
    }*/
    
    public String toString(){
        if(movie)
            return name + "\tStatus: " + finished;
        return name + " " + ((finished) ? "      OVERALL RATING: " + rating : "      Episode " + episode + " out of " + totEpisodes);
    }
    
    public String saveString(){
        return name + "," + episode + "," + totEpisodes + "," + finished + "," + movie + "," + rating;
    }
}
