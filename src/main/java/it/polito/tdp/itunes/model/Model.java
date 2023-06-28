package it.polito.tdp.itunes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.itunes.db.ItunesDAO;

public class Model {
	ItunesDAO dao;
	Graph<Track, DefaultWeightedEdge> grafo;
	Map<Integer, Track> mappaTrack;
	List<Arco> archi;
	public Model() {
		dao= new ItunesDAO();
		mappaTrack= new HashMap<>();
		dao.getAllTracks(mappaTrack);
	}
	public List<Genre> getAllGenre(){
		return dao.getAllGenres();
	}
	public void buildGraph(Genre genere) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.getTrackByGenre(genere));
	    archi= dao.getAllArchi(mappaTrack, genere);
		for(Arco a: archi) {
			Graphs.addEdge(grafo, a.getTrack1(), a.getTrack2(), a.getPreso());
		}
	}
	public int getNumVertici() {
		return grafo.vertexSet().size();
	}
	public int getNumArchi() {
		return grafo.edgeSet().size();
	}
	public List<Arco> getMax(){
		double max=0;
		List<Arco> result= new ArrayList<>();
		for(Arco a: archi) {
			if(a.getPreso()>max)
				max=a.getPreso();
		}
		for(Arco a:archi) {
			if(a.getPreso()==max) 
				result.add(a);
		}
		return result;
	}
}
