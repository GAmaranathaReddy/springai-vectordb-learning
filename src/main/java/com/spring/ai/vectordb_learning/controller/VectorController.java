package com.spring.ai.vectordb_learning.controller;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.Neo4jVectorStore;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VectorController {
	
	@Autowired
	private EmbeddingModel embeddingModel;
	
	@Autowired
	private Neo4jVectorStore neo4jVectorStore;
	
	@GetMapping("/neo4j/similarity")
	public List<Document> similarityNeo4JSearch(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message, 
			@RequestParam(value = "topP", defaultValue = "4") Integer topK, @RequestParam(value = "similarityThreshold", defaultValue = "0.8") Float similarityThreshold) {
		return neo4jVectorStore.similaritySearch(
                SearchRequest.defaults()
                .withQuery("The World")
                .withTopK(topK)
                .withSimilarityThreshold(similarityThreshold)
                .withFilterExpression("state_name in ['john', 'jill'] && 'article_type' == 'blog'"));
		
	}
	
}
