package org.hackathon.openassets.business;

import org.hackathon.openassets.model.DocumentForm;
import org.hackathon.openassets.model.MappedDocument;
import org.hackathon.openassets.model.SubmittedValue;
import org.hackathon.openassets.model.SubmittedValue.TranscriptionText;

/**
 * Handles document transcriptions, submitted by users.
 */
public class DocumentTranscriptionProcessor {

	private SimpleSentenceComparator comparator;

	/**
	 * Updates provided mapped document with given transcription using provided
	 * comparator.
	 * 
	 * @param document
	 *            mapped document
	 * @param transcription
	 * @param comparator
	 */
	public void processTranscription(MappedDocument document,
			DocumentForm transcription, SimpleSentenceComparator comparator) {
		this.comparator = comparator;

		updateTranscriptions(document.getName(), transcription.getName());
		updateTranscriptions(document.getDate_of_birth(),
				transcription.getDate_of_birth());
		updateTranscriptions(document.getPlace_of_birth(),
				transcription.getPlace_of_birth());
		updateTranscriptions(document.getWork(), transcription.getWork());
		updateTranscriptions(document.getCash_pln(),
				transcription.getCash_pln());
		updateTranscriptions(document.getCash_other(),
				transcription.getCash_other());
		updateTranscriptions(document.getStocks(), transcription.getStocks());
		updateTranscriptions(document.getHouse_area(),
				transcription.getHouse_area());
		updateTranscriptions(document.getHouse_value(),
				transcription.getHouse_value());
		updateTranscriptions(document.getHouse_ownership(),
				transcription.getHouse_ownership());
		updateTranscriptions(document.getFlat_area(),
				transcription.getFlat_area());
		updateTranscriptions(document.getFlat_value(),
				transcription.getFlat_value());
		updateTranscriptions(document.getFlat_ownership(),
				transcription.getFlat_ownership());
		updateTranscriptions(document.getFarm_type(),
				transcription.getFarm_type());
		updateTranscriptions(document.getFarm_area(),
				transcription.getFarm_area());
		updateTranscriptions(document.getFarm_value(),
				transcription.getFarm_value());
		updateTranscriptions(document.getFarm_buildings(),
				transcription.getFarm_buildings());
		updateTranscriptions(document.getFarm_ownership(),
				transcription.getFarm_ownership());
		updateTranscriptions(document.getFarm_income(),
				transcription.getFarm_income());
		updateTranscriptions(document.getOther_realestate(),
				transcription.getOther_realestate());
		updateTranscriptions(document.getStocks_participation(),
				transcription.getStocks_participation());
		updateTranscriptions(document.getStocks_income(),
				transcription.getStocks_income());
		updateTranscriptions(document.getStocks_government(),
				transcription.getStocks_government());
		updateTranscriptions(document.getStocks_government_more_10_proc(),
				transcription.getStocks_government_more_10_proc());
		updateTranscriptions(document.getStocks_government_income(),
				transcription.getStocks_government_income());
		updateTranscriptions(document.getStocks_commercial_company(),
				transcription.getStocks_commercial_company());
		updateTranscriptions(document.getStocks_commercial_company_income(),
				transcription.getStocks_commercial_company_income());
		updateTranscriptions(
				document.getStocks_commercial_company_government(),
				transcription.getStocks_commercial_company_government());
		updateTranscriptions(
				document.getStocks_commercial_company_government_more_10proc(),
				transcription
						.getStocks_commercial_company_government_more_10proc());
		updateTranscriptions(
				document.getStocks_commercial_company_government_income(),
				transcription.getStocks_commercial_company_government_income());
		updateTranscriptions(document.getStocks_other_company(),
				transcription.getStocks_other_company());
		updateTranscriptions(document.getStocks_other_company_income(),
				transcription.getStocks_other_company_income());
		updateTranscriptions(document.getAuction(), transcription.getAuction());
		updateTranscriptions(document.getSelf_employment(),
				transcription.getSelf_employment());
		updateTranscriptions(document.getSelf_employment_personal(),
				transcription.getSelf_employment_personal());
		updateTranscriptions(document.getSelf_employment_with_others(),
				transcription.getSelf_employment_with_others());
		updateTranscriptions(document.getSelf_employment_income(),
				transcription.getSelf_employment_income());
		updateTranscriptions(document.getRepresent_self_employment(),
				transcription.getRepresent_self_employment());
		updateTranscriptions(document.getRepresent_self_personal(),
				transcription.getRepresent_self_personal());
		updateTranscriptions(document.getRepresent_self_with_others(),
				transcription.getRepresent_self_with_others());
		updateTranscriptions(document.getRepresent_self_income(),
				transcription.getRepresent_self_income());
		updateTranscriptions(document.getPublic_company(),
				transcription.getPublic_company());
		updateTranscriptions(document.getPublic_company_board(),
				transcription.getPublic_company_board());
		updateTranscriptions(document.getPublic_company_directors(),
				transcription.getPublic_company_directors());
		updateTranscriptions(document.getPublic_company_audit(),
				transcription.getPublic_company_audit());
		updateTranscriptions(document.getPublic_company_income(),
				transcription.getPublic_company_income());
		updateTranscriptions(document.getFoundation(),
				transcription.getFoundation());
		updateTranscriptions(document.getFoundation_board(),
				transcription.getFoundation_board());
		updateTranscriptions(document.getFoundation_directors(),
				transcription.getFoundation_directors());
		updateTranscriptions(document.getFoundation_audit(),
				transcription.getFoundation_audit());
		updateTranscriptions(document.getFoundation_income(),
				transcription.getFoundation_income());
		updateTranscriptions(document.getOther_income(),
				transcription.getOther_income());
		updateTranscriptions(document.getCars(), transcription.getCars());
		updateTranscriptions(document.getLiabilities(),
				transcription.getLiabilities());
	}

	public void updateTranscriptions(SubmittedValue fieldTranscription,
			String transcription) {
		TranscriptionText transcriptionTxt = new TranscriptionText(
				transcription);
		for (TranscriptionText txt : fieldTranscription.getSubmittedValues()) {
			if (comparator.compare(txt.getText(), transcription)) {
				txt.setValidLevel(txt.getValidLevel() + 1);
				transcriptionTxt
						.setValidLevel(transcriptionTxt.getValidLevel() + 1);
			}
		}
		fieldTranscription.getSubmittedValues().add(transcriptionTxt);
	}
}
